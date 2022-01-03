/*
 * https://leetcode.com/problems/gas-station/
 * O(n) time | O(1) space
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, min = Integer.MAX_VALUE, minIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];

            if (sum < min) {
                min = sum;
                minIndex = (sum < 0) ? i + 1 : 0;
            }
        }
        return (sum >= 0) ? (minIndex % gas.length) : -1;
    }
}
