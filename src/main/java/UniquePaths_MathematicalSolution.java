/*
 * https://leetcode.com/problems/unique-paths/
 * O(m-1) or O(n-1) time depending upon what you choose in the loop | O(1)
 */
public class UniquePaths_MathematicalSolution {
    public int uniquePaths(int m, int n) {
        /*
         _ _ _ _
        |_|_|_|_|
        |_|_|_|_|
        |_|_|_|_|

        No. of different paths can be:
        R R R D D
        D R R R D
        D D R R R
        D D D R R
        D D R R D
        ....and so on

        Total no. to choose from (R + D combination): N = (m-1) + (n-1) = m + n - 2
        nCr = nCn-r
        */

        int N = m + n - 2;
        int r = m - 1;
        double res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int)res;
    }
}
