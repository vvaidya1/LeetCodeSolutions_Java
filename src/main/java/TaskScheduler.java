import java.util.*;

/*
 * https://leetcode.com/problems/task-scheduler/
 * O(n) time | O(n) space
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks)
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        maxHeap.addAll(map.values());

        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }

            for (int i : temp) {
                if (--i > 0)
                    maxHeap.add(i);
            }

            cycles += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return cycles;
    }
}
