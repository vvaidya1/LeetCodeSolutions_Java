import java.util.*;

/*
 * https://leetcode.com/problems/combination-sum-ii/
 * O(k.2^n) time | O(k.x) space - where t is the max number of times you decide to pick a particular element,
 * k is average length (ignoring auxiliary space taken by recursive stack), and x is number of possible combinations
 * Reference https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=51
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;

        Arrays.sort(candidates);
        combinationSum2Helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    void combinationSum2Helper(int[] candidates, int startIndex, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            if (i > startIndex && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > target) break;

            current.add(candidates[i]);
            combinationSum2Helper(candidates, i + 1, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}
