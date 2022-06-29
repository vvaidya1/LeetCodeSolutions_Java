import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 * Time Complexity: O(n.log.n + n^2) = O(n^2): We sort the array in O(n.log.n) time and list insertion will take O(n^2) for n insertions at worst.
 * Space Complexity: O(n)
 * Reference: https://leetcode.com/problems/queue-reconstruction-by-height/discuss/2211641/Visual-Explanation-or-JAVA-Greedy
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0)
            return people;

        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));

        List<int[]> list = new LinkedList<>();
        for (int[] p : people)
            list.add(p[1], p);

        return list.toArray(new int[people.length][2]);
    }
}
