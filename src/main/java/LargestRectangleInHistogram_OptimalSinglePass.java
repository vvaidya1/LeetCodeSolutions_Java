import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * O(n) time | O (n) space
 */
public class LargestRectangleInHistogram_OptimalSinglePass {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.peek()];
                stack.pop();

                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
