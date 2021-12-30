import java.util.*;

/*
 * https://leetcode.com/problems/palindrome-partitioning/
 * O(n.2^n) time | O(n^2) space
 */
public class PalindromePartitioning_BackTracking {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), partitions);
        return partitions;
    }

    void partitionHelper(String s, int startIndex, List<String> current, List<List<String>> partitions) {
        if (startIndex == s.length()) {
            partitions.add(new ArrayList<>(current));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                current.add(s.substring(startIndex, i + 1));
                partitionHelper(s, i + 1, current, partitions);
                current.remove(current.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
