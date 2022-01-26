import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/min-stack/
 * O(1) time | O(n) space
 */
public class MinStack_CleanUsesList {
    List<MinStackInfo> stack;

    public MinStack_CleanUsesList() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        if (stack.size() == 0)
            stack.add(new MinStackInfo(val, val));
        else {
            MinStackInfo item = stack.get(stack.size() - 1);
            stack.add(new MinStackInfo(val, Math.min(item.minValue, val)));
        }
    }

    public void pop() {
        if (stack.size() > 0)
            stack.remove(stack.size() - 1);
    }

    public int top() {
        return (stack.size() > 0) ? stack.get(stack.size() - 1).value : -1;
    }

    public int getMin() {
        return (stack.size() > 0) ? stack.get(stack.size() - 1).minValue : -1;
    }

    class MinStackInfo {
        int value;
        int minValue;

        public MinStackInfo(int val, int min) {
            value = val;
            minValue = min;
        }
    }
}