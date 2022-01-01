/*
 * https://leetcode.com/problems/container-with-most-water/
 * O(n) time | O(1) space
 */
public class ContainerWithMostWater_Optimal {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1, maxArea = 0;

        while (start < end) {
            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));

            if (height[start] < height[end])
                start++;
            else
                end--;
        }
        return maxArea;
    }
}
