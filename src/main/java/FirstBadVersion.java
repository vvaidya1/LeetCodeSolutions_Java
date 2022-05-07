/* The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version); */

import java.util.Random;

/*
 * https://leetcode.com/problems/first-bad-version/
 * O(log.n) time | O(1) space
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    // Below method is just to make above function compile.
    // As indicated in the question, actual method is defined in VersionControl class.
    boolean isBadVersion(int version) {
        return new Random().nextBoolean();
    }
}
