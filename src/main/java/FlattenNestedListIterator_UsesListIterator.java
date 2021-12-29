import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/*
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 */
public class FlattenNestedListIterator_UsesListIterator {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    public static class NestedIterator implements Iterator<Integer> {
        Stack<ListIterator<NestedInteger>> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            stack.push(nestedList.listIterator());
        }

        @Override
        public Integer next() {
            if (hasNext())
                return stack.peek().next().getInteger();
            return null;
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                if (!stack.peek().hasNext()) {
                    stack.pop();
                } else {
                    NestedInteger ni = stack.peek().next();
                    if (ni.isInteger())
                        return stack.peek().previous() == ni;
                    stack.push(ni.getList().listIterator());
                }
            }
            return false;
        }
    }

    public abstract static class NestedInteger {
        public boolean isInteger() {
            throw new RuntimeException();
        }

        public List<NestedInteger> getList() {
            throw new RuntimeException();
        }

        public Integer getInteger() {
            throw new RuntimeException();
        }
    }

    /*
    Your NestedIterator object will be instantiated and called as such:
    NestedIterator i = new NestedIterator(nestedList);
    while (i.hasNext()) v[f()] = i.next();
    */
}
