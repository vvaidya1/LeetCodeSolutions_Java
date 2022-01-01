import java.util.*;

/*
 * https://leetcode.com/problems/happy-number/
 * O(log.n) time | O(log.n) space
 */
public class HappyNumber_Optimal {
    public boolean isHappy(int n) {
        int slow = getNextNumber(n);
        int fast = getNextNumber(slow);

        while (fast != 1 && slow != fast) {
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        }

        return fast == 1;
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
