import java.util.*;
/*
 * https://leetcode.com/problems/triangle/
 * O(n^2) time | O(1) space - where n is the number of rows in the input
 */
public class Triangle_TopDown {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int sum;
                if (j == 0)
                    sum = triangle.get(i).get(j) + triangle.get(i - 1).get(j);
                else if (j == triangle.get(i).size() - 1)
                    sum = triangle.get(i).get(j) + triangle.get(i - 1).get(triangle.get(i - 1).size() - 1);
                else
                    sum = triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));
                triangle.get(i).set(j, sum);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}
