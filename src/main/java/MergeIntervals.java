import java.util.*;

/*
 * https://leetcode.com/problems/merge-intervals/
 * O(n) time | O(n) space
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][0];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] current = intervals[0];

        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] < intervals[i][0]) {
                result.add(current);
                current = intervals[i];
            }
            else {
                current[1] = Math.max(current[1], intervals[i][1]);
            }
        }
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}
