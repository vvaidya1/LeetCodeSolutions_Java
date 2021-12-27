import java.util.*;

/*
 * https://leetcode.com/problems/pascals-triangle/
 * O(n^2) time | O(n^2) space where n = number of rows
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            for(int j = newList.size() - 1; j > 0; j--) {
                newList.set(j, newList.get(j - 1) + newList.get(j));
            }
            newList.add(1);
            result.add(new ArrayList<>(newList));
        }
        return result;
    }
}
