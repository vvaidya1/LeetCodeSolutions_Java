/*
 * https://leetcode.com/problems/number-of-islands/
 * O(m * n) time | O(1) space where m and n are length and width of grid respectively
 */
public class NumberOfIslands_Optimal {
    int[] delta = {0, 1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int noOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0')
                    continue;

                noOfIslands += 1;
                dfs(grid, i, j);
            }
        }
        return noOfIslands;
    }

    void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        for (int k = 0; k < delta.length - 1; k++)
            dfs(grid, i + delta[k], j + delta[k + 1]);
    }
}
