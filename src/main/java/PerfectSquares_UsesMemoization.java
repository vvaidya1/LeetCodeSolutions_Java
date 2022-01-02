import java.util.*;

/*
 * https://leetcode.com/problems/perfect-squares/
 * O(n.sqrt(n)) time | O(n) space
 */
public class PerfectSquares_UsesMemoization {
    Map<Integer, Integer> memoize = new HashMap<>() {{
        put(0, 0);
        put(1, 1);
        put(2, 2);
    }};

    public int numSquares(int n) {
        return dfs(n);
    }

    int dfs(int n) {
        if (memoize.containsKey(n))
            return memoize.get(n);

        int num = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            num = Math.min(num, dfs(n - i * i) + 1);
        }
        memoize.put(n, num);
        return num;
    }
}
