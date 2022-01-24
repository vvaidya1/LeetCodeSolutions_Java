import java.util.*;

/*
 * https://leetcode.com/problems/maximum-xor-with-an-element-from-array/
 * ((q.log.q) / O(n.log.n)) + O(q.32 + n.32) time | O(n.32) space
 */
public class MaxXorWithAnElementFromArray {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        List<QueryInfo> queryInfoList = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            queryInfoList.add(new QueryInfo(queries[i][0], queries[i][1], i));
        }

        queryInfoList.sort(Comparator.comparingInt(a -> a.maxNum));
        Arrays.sort(nums);

        int[] answer = new int[queries.length];
        int i = 0;
        Trie trie = new Trie();
        for (QueryInfo q : queryInfoList) {
            while (i < nums.length && nums[i] <= q.maxNum) {
                trie.insert(nums[i++]);
            }

            if (i != 0)
                answer[q.index] = trie.maxXor(q.numXor);
            else
                answer[q.index] = -1;
        }
        return answer;
    }

    class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }

        public boolean contains(int item) {
            return children[item] != null;
        }

        public TrieNode get(int bit) {
            return children[bit];
        }
    }

    class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(int num) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.contains(bit))
                    node.children[bit] = new TrieNode();
                node = node.get(bit);
            }
        }

        public int maxXor(int num) {
            TrieNode node = root;
            int value = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.contains(1 - bit)) {
                    value += (1 << i);
                    node = node.get(1 - bit);
                } else
                    node = node.get(bit);
            }
            return value;
        }
    }

    class QueryInfo {
        int numXor;
        int maxNum;
        int index;

        public QueryInfo(int n, int m, int i) {
            numXor = n;
            maxNum = m;
            index = i;
        }
    }
}
