package design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/design-parking-system
 * Difficulty: Easy
 */
public class DesignParkingSystem {

    /**
     * Time complexity: O(1)
     * Space complexity: O(n)
     */
    private static class ParkingSystemViaMap {

        private final Map<CarType, Integer> slots;

        public ParkingSystemViaMap(int big, int medium, int small) {
            this.slots = new HashMap<>();
            slots.put(CarType.BIG, big);
            slots.put(CarType.MEDIUM, medium);
            slots.put(CarType.SMALL, small);
        }

        public boolean addCar(int carType) {
            return slots.merge(CarType.getById(carType), -1, Integer::sum) >= 0;
        }

        private enum CarType {

            BIG(1),
            MEDIUM(2),
            SMALL(3);

            private final int id;

            CarType(int id) {
                this.id = id;
            }

            public static CarType getById(int id) {
                return Arrays.stream(CarType.values())
                        .filter(c -> c.id == id)
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Unknown car type id: " + id));
            }
        }
    }

    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    private static class ParkingSystemViaCounters {

        private static final int BIG_CAR = 1;
        private static final int MEDIUM_CAR = 2;
        private static final int SMALL_CAR = 3;

        private int big;
        private int medium;
        private int small;

        public ParkingSystemViaCounters(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == BIG_CAR && big > 0) {
                big--;
                return true;
            }

            if (carType == MEDIUM_CAR && medium > 0) {
                medium--;
                return true;
            }

            if (carType == SMALL_CAR && small > 0) {
                small--;
                return true;
            }

            return false;
        }
    }
}
