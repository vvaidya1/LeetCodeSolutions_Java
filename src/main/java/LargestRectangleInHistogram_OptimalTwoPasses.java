import java.util.*;

/*
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * O(n) time | O (n) space
 */
public class LargestRectangleInHistogram_OptimalTwoPasses {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] leftSmaller = new int[heights.length];
        int[] rightSmaller = new int[heights.length];

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftSmaller[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        stack = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rightSmaller[i] = stack.isEmpty() ? heights.length - 1 : stack.peek() - 1;
            stack.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightSmaller[i] - leftSmaller[i] + 1));
        }

        return maxArea;
    }
}
