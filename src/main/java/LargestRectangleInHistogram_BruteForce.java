/*
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * O(n^2) time | O(1) space
 * Throws TLE (Time Limit Exceeded) exception on submission
 */
public class LargestRectangleInHistogram_BruteForce {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
}
