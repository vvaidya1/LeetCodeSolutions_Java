/*
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * O(m.n) time | O(m.n) space
 */
public class LongestIncreasingPathInAMatrix {
    int[] delta = {0, 1, 0, -1, 0};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int result = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, dfs(matrix, Integer.MIN_VALUE, i, j, cache));
            }
        }
        return result;
    }

    int dfs(int[][] matrix, int parentValue, int i, int j, int[][] cache) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= parentValue)
            return 0;

        if (cache[i][j] != 0)
            return cache[i][j];

        int result = 0;
        for (int k = 0; k < delta.length - 1; k++) {
            result = Math.max(result, 1 + dfs(matrix, matrix[i][j], i + delta[k], j + delta[k + 1], cache));
        }
        cache[i][j] = result;
        return result;
    }
}
