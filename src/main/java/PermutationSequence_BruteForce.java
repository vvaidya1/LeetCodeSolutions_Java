import java.util.*;

/*
 * https://leetcode.com/problems/permutation-sequence/
 * O(n!.n) + O(n!.log.n!) time | O(n!) space
 * Throws Time Limit Exceeded (TLE) error on Leetcode
 */
public class PermutationSequence_BruteForce {
    public String getPermutation(int n, int k) {
        if (n == 1)
            return "1";

        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }

        List<String> result = new ArrayList<>();
        permutationsHelper(s.toString().toCharArray(), 0, result);
        Collections.sort(result);
        return result.get(k - 1);
    }

    void permutationsHelper(char[] input, int i, List<String> result) {
        if (i == input.length) {
            result.add(String.valueOf(input));
            return;
        }

        for (int j = i; j < input.length; j++) {
            swap(input, i, j);
            permutationsHelper(input, i + 1, result);
            swap(input, i, j);
        }
    }

    void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
