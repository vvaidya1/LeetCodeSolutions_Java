import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/online-stock-span/
 * O(n) time | O(1) space
 */
public class OnlineStockSpan {
    int index;
    Deque<PriceInfo> stack;

    public OnlineStockSpan() {
        index = -1;
        stack = new ArrayDeque<>();
        stack.push(new PriceInfo(Integer.MAX_VALUE, index));
    }

    public int next(int price) {
        PriceInfo newPrice = new PriceInfo(price, ++index);
        while (!stack.isEmpty() && stack.peek().price <= price)
            stack.pop();

        int ans = index - stack.peek().index;
        stack.push(newPrice);
        return ans;
    }

    static class PriceInfo {
        int price;
        int index;

        public PriceInfo(int p, int ind) {
            price = p;
            index = ind;
        }
    }
}
