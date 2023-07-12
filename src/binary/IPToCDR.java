package binary;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/ip-to-cidr
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class IPToCDR {

    private static final int BLOCK_SIZE = 8;

    public List<String> ipToCIDR(String ip, int n) {
        long currentIp = toBase10(ip); // convert Base256 to Base10

        List<String> result = new ArrayList<>();
        while (n > 0) {
            // 1. 255.0.0.8 -> 4278190088 -> 1111 1111 0000 0000 0000 0000 0000 [1]000
            // 2. lowest = ...[1]000 -> 8, highest = 8 -> [1]000 = 8
            // 3. blockSize = min(8, 8) = 8
            // 4. usedBits = 1[000] = 3
            // 5. cidr = 255.0.0.8/29
            // 6. ip = 4278190088 + 8 -> 1111 1111 0000 0000 0000 0000 0001 0000
            long lowest = Long.lowestOneBit(currentIp);
            long highest = Long.highestOneBit(n);
            long blockSize = lowest == 0 ? highest : Math.min(lowest, highest);

            int usedBits = Long.numberOfTrailingZeros(blockSize);
            String cidr = toString(currentIp) + "/" + (32 - usedBits);
            result.add(cidr);

            currentIp += blockSize;
            n -= blockSize;
        }

        return result;
    }

    private long toBase10(String ip) {
        String[] blocks = ip.split("\\.");
        long converted = 0L;
        for (int i = 0; i < 4; i++) {
            converted = converted * 256 + Integer.parseInt(blocks[i]);
        }

        return converted;
    }

    private String toString(long ip) {
        StringBuilder converted = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            // shift 8*i positions to the right and take 8 digits
            long block = ((ip >> (BLOCK_SIZE * i)) & 255);
            converted.append(block).append(".");
        }

        converted.deleteCharAt(converted.length() - 1); // remove extra dot
        return converted.toString();
    }

    public static void main(String[] args) {
        // 255.0.0.7/32 : 255.0.0.7
        // 255.0.0.8/29 : 255.0.0.8, 255.0.0.9, 255.0.0.10, 255.0.0.11, 255.0.0.12, 255.0.0.13, 255.0.0.14, 255.0.0.15
        // 255.0.0.16/32: 255.0.0.16
        System.out.println(new IPToCDR().ipToCIDR("255.0.0.7", 10));
    }
}
