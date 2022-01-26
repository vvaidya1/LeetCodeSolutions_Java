import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/min-stack/
 * O(n) time | O(n) space
 */
public class MinStack_Optimal {
    Long minValue;
    List<Long> stack;

    public MinStack_Optimal() {
        minValue = Long.MAX_VALUE;
        stack = new ArrayList<>();
    }

    public void push(int val) {
        Long value = (long) val;
        if (stack.isEmpty()) {
            stack.add(value);
            minValue = value;
        } else {
            if (value < minValue) {
                stack.add(2 * value - minValue);
                minValue = value;
            } else {
                stack.add(value);
            }
        }
    }

    public void pop() {
        Long top = stack.get(stack.size() - 1);
        if (top < minValue)
            minValue = 2 * minValue - top;
        stack.remove(stack.size() - 1);
    }

    public int top() {
        Long top = stack.get(stack.size() - 1);
        if (top < minValue) {
            return minValue.intValue();
        }
        return top.intValue();
    }

    public int getMin() {
        return minValue.intValue();
    }
}
