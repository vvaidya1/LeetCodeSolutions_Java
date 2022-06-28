/**
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 * O(n) time | O(1) space - where n is the length of input string
 */
public class PartitioningIntoMinNumOfDecibinaryNums {
    public int minPartitions(String n) {
        if (n == null || n.length() == 0)
            return 0;

        int result = 0;
        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            if (ch - '0' == 9)
                return 9;
            result = Math.max(result, ch - '0');
        }
        return result;
    }
}
