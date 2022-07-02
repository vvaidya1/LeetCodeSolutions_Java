import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 * O(n.log.n) time | O(1) space - where n is the length of input array
 */
public class MaxUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (boxTypes == null || boxTypes.length == 0)
            return 0;

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0, i = 0;
        while (i < boxTypes.length && truckSize > 0) {
            int maxi = Math.min(boxTypes[i][0], truckSize);
            ans += maxi * boxTypes[i][1];
            i++;
            truckSize -= maxi;
        }
        return ans;
    }
}
