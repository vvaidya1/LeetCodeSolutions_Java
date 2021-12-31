import java.util.Stack;

/*
 * https://leetcode.com/problems/trapping-rain-water/
 * O(n) time | O(n) space
 */
public class TrappedRainWater_UsesStack {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int trappedWater = 0;
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int top = stack.peek();
                stack.pop();

                if (stack.isEmpty())
                    break;
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                trappedWater += distance * boundedHeight;
            }
            stack.push(i);
        }
        return trappedWater;
    }
}
