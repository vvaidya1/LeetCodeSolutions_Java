import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/permutation-sequence/
 * O(n.n) time | O(n) space
 */
public class PermutationSequence_Optimal {
    public String getPermutation(int n, int k) {
        if (n == 1)
            return "1";

        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            nums.add(i);
        }
        nums.add(n);

        k = k - 1;
        StringBuilder answer = new StringBuilder();
        while (true) {
            answer.append(nums.get(k / fact));
            nums.remove(k / fact);

            if (nums.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / nums.size();
        }

        return answer.toString();
    }
}
