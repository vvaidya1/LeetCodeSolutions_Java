/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * O(n) time | O(1) space
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                maxProfit += prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }
}
