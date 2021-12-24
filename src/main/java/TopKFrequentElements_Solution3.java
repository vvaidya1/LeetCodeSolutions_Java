import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/top-k-frequent-elements/
 * O(n) time average case - O(n^2) worst case | O(n) where n = total elements
 * Uses quick select algorithm for partitioning as quick sort
 */
public class TopKFrequentElements_Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        List<Integer> uniqueElements = new ArrayList<>(frequency.keySet());
        return quickSelect(uniqueElements, frequency, k, 0, uniqueElements.size() - 1);
    }

    int[] quickSelect(List<Integer> uniqueElements, Map<Integer, Integer> frequency, int k, int start, int end) {
        if (start > end) {
            return new int[]{};
        }

        int pivot = partition(uniqueElements, frequency, k, start, end);
        if (pivot == uniqueElements.size() - k) {
            int[] result = new int[k];
            int j = 0;
            for (int i = uniqueElements.size() - k; i < uniqueElements.size(); i++) {
                result[j++] = uniqueElements.get(i);
                System.out.println(result[0]);
            }
            return result;
        } else if (pivot < uniqueElements.size() - k) {
            return quickSelect(uniqueElements, frequency, k, pivot + 1, end);
        } else {
            return quickSelect(uniqueElements, frequency, k, start, pivot - 1);
        }
    }

    int partition(List<Integer> uniqueElements, Map<Integer, Integer> frequency, int k, int start, int end) {
        if (start == end)
            return start;

        int candidate = uniqueElements.get(end);
        int i = start;
        for (int j = i; j < end; j++) {
            if (frequency.get(uniqueElements.get(j)) < frequency.get(candidate)) {
                swap(uniqueElements, i, j);
                i++;
            }
        }
        swap(uniqueElements, i, end);
        System.out.println(uniqueElements);
        return i;
    }

    void swap(List<Integer> uniqueElements, int i, int j) {
        int temp = uniqueElements.get(i);
        uniqueElements.set(i, uniqueElements.get(j));
        uniqueElements.set(j, temp);
    }
}
