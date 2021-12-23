import java.util.HashMap;
import java.util.Map;

//O(n * k) time | O(k) - n = total elements, k = number of frequent elements to return
public class TopKFrequentElements_Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            if (frequency.containsKey(num)) {
                int val = frequency.get(num) + 1;
                frequency.put(num, val);
            } else
                frequency.put(num, 1);
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            int key = frequency.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
            result[i] = key;
            frequency.remove(key);
        }
        return result;
    }
}
