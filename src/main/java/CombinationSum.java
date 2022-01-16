import java.util.*;

/*
 * https://leetcode.com/problems/combination-sum/
 * O(k.2^t) time | O(k.x) space - where t is the max number of times you decide to pick a particular element and k is average length
 * Reference https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=50
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void combinationSumHelper(int[] candidates, int startIndex, int target, List<Integer> current, List<List<Integer>> result) {
        if (startIndex == candidates.length) {
            if (target == 0)
                result.add(new ArrayList<>(current));
            return;
        }

        if (candidates[startIndex] <= target) {
            current.add(candidates[startIndex]);
            combinationSumHelper(candidates, startIndex, target - candidates[startIndex], current, result);
            current.remove(current.size() - 1);
        }
        combinationSumHelper(candidates, startIndex + 1, target, current, result);
    }
}
