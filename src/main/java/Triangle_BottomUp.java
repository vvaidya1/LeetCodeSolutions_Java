import java.util.List;

/*
 * https://leetcode.com/problems/triangle/
 * O(n^2) time | O(1) space - where n is the number of rows in the input
 * Reference https://www.youtube.com/watch?v=O2eaAdBpZBQ
 */
public class Triangle_BottomUp {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
