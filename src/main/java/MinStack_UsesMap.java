import java.util.*;

/*
 * https://leetcode.com/problems/min-stack/
 * O(1) time | O(n) space
 */
public class MinStack_UsesMap {
    Map<Integer, MinStackInfo> map;
    int top;

    public MinStack_UsesMap() {
        map = new HashMap<>();
        top = -1;
    }

    public void push(int val) {
        ++top;
        if (top == 0)
            map.put(top, new MinStackInfo(val, val, top));
        else {
            MinStackInfo minInfo = map.get(top - 1);
            if (val <= minInfo.minElement)
                map.put(top, new MinStackInfo(val, val, top));
            else
                map.put(top, new MinStackInfo(val, minInfo.minElement, minInfo.minIndex));
        }
    }

    public void pop() {
        map.remove(top);
        top--;
    }

    public int top() {
        return map.get(top).value;
    }

    public int getMin() {
        int minIndex = map.get(top).minIndex;
        return map.get(minIndex).value;
    }
}

class MinStackInfo {
    int value;
    int minElement;
    int minIndex;

    public MinStackInfo(int val, int element, int index) {
        value = val;
        minElement = element;
        minIndex = index;
    }
}

/*
 * Your MinStack_UsesMap object will be instantiated and called as such:
 * MinStack_UsesMap obj = new MinStack_UsesMap();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */