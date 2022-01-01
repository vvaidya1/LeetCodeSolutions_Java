import java.util.*;

/*
 * https://leetcode.com/problems/happy-number/
 * O(log.n) time | O(log.n) space
 */
public class HappyNumber_UsesHashSet {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (!seen.contains(n)) {
            if (n == 1)
                return true;

            seen.add(n);
            n = getNextNumber(n);
        }
        return false;
    }

    int getNextNumber(int n) {
        int nextNum = 0;
        while (n > 0) {
            int digit = n % 10;
            nextNum += digit * digit;
            n = n / 10;
        }
        return nextNum;
    }
}
