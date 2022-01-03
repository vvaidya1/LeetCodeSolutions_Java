import java.util.*;

/*
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * O(n) time | O(n) space
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0, currentStreak;
        for (int item : set) {
            if (!set.contains(item - 1)) {
                int currentNum = item;
                currentStreak = 0;
                while (set.contains(currentNum)) {
                    currentNum += 1;
                    currentStreak++;

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }
        }
        return longestStreak;
    }
}
