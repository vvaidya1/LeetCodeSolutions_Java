import java.util.*;

/*
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * O(1) time | O(n) space - where n is number of elements in the set at any give time
 */
class RandomizedSetI {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSetI() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int i = map.get(val);
        Collections.swap(list, i, list.size() - 1);
        map.put(list.get(i), i);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/*
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */