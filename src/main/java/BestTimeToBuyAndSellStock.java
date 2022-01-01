/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * O(n) time | O(1) space
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxProfit = 0, minValue = prices[0], i = 0;
        while (i < prices.length) {
            minValue = Math.min(minValue, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
            i++;
        }
        return maxProfit;
    }
}
