import java.util.Arrays;

/*
 * https://leetcode.com/problems/perfect-squares/
 * O(n.sqrt(n)) time | O(n) space
 */
public class PerfectSquaresPerfectSquares_UesTabulation {
    int[] dp;

    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(n); j++) {
                if (i - j * j < 0)
                    break;
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
