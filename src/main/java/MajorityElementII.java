import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/majority-element-ii/
 * O(n) time | O(1) space
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return null;

        int countOne = 0, countTwo = 0, candidateOne = Integer.MIN_VALUE, candidateTwo = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == candidateOne)
                countOne++;
            else if (num == candidateTwo)
                countTwo++;
            else if (countOne == 0) {
                candidateOne = num;
                countOne++;
            } else if (countTwo == 0) {
                candidateTwo = num;
                countTwo++;
            } else {
                countOne--;
                countTwo--;
            }
        }

        countOne = countTwo = 0;
        for (int num : nums) {
            if (num == candidateOne)
                countOne++;
            else if (num == candidateTwo)
                countTwo++;
        }

        if (countOne > nums.length / 3)
            result.add(candidateOne);

        if (countTwo > nums.length / 3)
            result.add(candidateTwo);

        return result;
    }
}
