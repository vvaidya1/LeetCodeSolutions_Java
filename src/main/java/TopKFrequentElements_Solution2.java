import java.util.*;

//O(n log(k)) time | O(n + k) where n = total elements, k = number of frequent elements to return
public class TopKFrequentElements_Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length)
            return nums;

        //Store frequencies
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        //Create min heap
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(frequency::get));

        int i = 0;
        for (Map.Entry entry : frequency.entrySet()) {
            int key = (int) entry.getKey();
            priorityQueue.add(key);
            i++;

            //Polling ensures that we always have k elements required to be returned
            //Also less frequent element gets removed as it is a min heap
            if (i > k) priorityQueue.poll();
        }

        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            result[j] = priorityQueue.poll();
        }

        return result;
    }
}
