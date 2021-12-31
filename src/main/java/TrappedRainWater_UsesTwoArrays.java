/*
 * https://leetcode.com/problems/trapping-rain-water/
 * O(n) time | O(n) space
 */
public class TrappedRainWater_UsesTwoArrays {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        int trappedWater = 0;
        for (int k = 0; k < height.length; k++) {
            trappedWater += Math.min(leftMax[k], rightMax[k]) - height[k];
        }
        return trappedWater;
    }
}
