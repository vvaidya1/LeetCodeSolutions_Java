import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/sliding-window-maximum/
 * O(n) time | O(k) space
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i >= k - 1)
                result[i - k + 1] = nums[deque.peek()];
        }
        return result;
    }
}
