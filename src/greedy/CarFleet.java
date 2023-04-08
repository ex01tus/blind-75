package greedy;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/car-fleet
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = toSortedByPositionCarArray(position, speed);
        return countFleetsNumber(cars, target);
    }

    private int countFleetsNumber(Car[] cars, int target) {
        int fleetsNumber = 1;
        Car nextCar = cars[cars.length - 1];
        double nextCarTime = computeTimeToReachTarget(nextCar.position, nextCar.speed, target);

        // first car will always lead the fleet, so we start from the second one
        for (int i = cars.length - 2; i >= 0; i--) {
            Car currentCar = cars[i];
            double currentCarTime = computeTimeToReachTarget(currentCar.position, currentCar.speed, target);

            // if a car needs more time to reach the target, than the next one, it will become a new fleet leader
            if (currentCarTime > nextCarTime) {
                fleetsNumber++;
                nextCarTime = currentCarTime;
            }
        }

        return fleetsNumber;
    }

    private Car[] toSortedByPositionCarArray(int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, (c1, c2) -> Integer.compare(c1.position, c2.position));

        return cars;
    }

    private double computeTimeToReachTarget(int position, int speed, int target) {
        return (double) (target - position) / speed;
    }

    private record Car(int position, int speed) {
    }
}
