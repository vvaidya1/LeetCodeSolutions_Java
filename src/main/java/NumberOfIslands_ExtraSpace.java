/*
 * https://leetcode.com/problems/number-of-islands/
 * O(m * n) time | O(m * n) space where m and n are length and width of grid respectively
 */
public class NumberOfIslands_ExtraSpace {
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        visited = new boolean[grid.length][grid[0].length];
        int noOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == '0')
                    continue;

                noOfIslands += 1;
                dfs(grid, i, j);
            }
        }
        return noOfIslands;
    }

    void dfs(char[][] grid, int i, int j) {
        if (visited[i][j] || grid[i][j] == '0')
            return;

        visited[i][j] = true;

        if (i - 1 >= 0)
            dfs(grid, i - 1, j);

        if (i + 1 < grid.length)
            dfs(grid, i + 1, j);

        if (j - 1 >= 0)
            dfs(grid, i, j - 1);

        if (j + 1 < grid[0].length)
            dfs(grid, i, j + 1);
    }
}
