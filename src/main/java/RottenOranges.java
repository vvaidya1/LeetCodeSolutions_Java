import Common.Cell;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/rotting-oranges/
 * O(m * n) time | O(m * n) space
 */
public class RottenOranges {
    int[] delta = {0, 1, 0, -1, 0};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;

        Queue<Cell> queue = new LinkedList<>();
        int totalOranges = 0, rottenOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    totalOranges++;

                if (grid[i][j] == 2) {
                    queue.offer(new Cell(i, j));
                    rottenOranges++;
                }
            }
        }

        int mins = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                Cell orange = queue.poll();
                for (int k = 1; k < delta.length; k++) {
                    int x = orange.i + delta[k - 1];
                    int y = orange.j + delta[k];

                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1)
                        continue;

                    grid[x][y] = 2;
                    queue.offer(new Cell(x, y));
                    rottenOranges++;
                }
            }

            if (!queue.isEmpty())
                mins++;
        }

        return totalOranges == rottenOranges ? mins : -1;
    }
}
