/*
 * https://leetcode.com/problems/unique-paths/
 * O(2^(n+m)) time | O(m+n) space
 * TLE error for lager inputs - use DP with memoization instead
 */
public class UniquePaths_Recursive {
    public int uniquePaths(int m, int n) {
        return uniquePathsHelper(0, 0, m-1, n-1);
    }

    int uniquePathsHelper(int i, int j, int m, int n) {
        if (i == m && j == n)
            return 1;

        int uniquePaths = 0;
        if (i + 1 <= m)
            uniquePaths += uniquePathsHelper(i + 1, j, m, n);

        if (j + 1 <= n)
            uniquePaths += uniquePathsHelper(i, j + 1, m, n);

        return uniquePaths;
    }
}
