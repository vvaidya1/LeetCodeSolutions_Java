import java.util.*;

/*
 * https://leetcode.com/problems/fruit-into-baskets/
 * O(n) time | O(1) space
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0)
            return 0;

        int maxTrees = Integer.MIN_VALUE, start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            if (map.size() <= 2) {
                map.put(fruits[i], i);
            }

            if (map.size() > 2) {
                int min = Integer.MAX_VALUE;
                for (int index : map.values()) {
                    min = Math.min(min, index);
                }
                map.remove(fruits[min]);
                start = min + 1;
            }
            maxTrees = Math.max(maxTrees, i - start + 1);
        }
        return maxTrees;
    }
}
