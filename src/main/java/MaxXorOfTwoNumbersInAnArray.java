/*
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * O(n.32) time | O(n.32) space
 */
public class MaxXorOfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();

        for (int num : nums)
            root.insert(num);

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            int xor = root.maxXor(num);
            max = Math.max(xor, max);
        }
        return max;
    }


    class TrieNode {
        TrieNode[] links;

        public TrieNode() {
            links = new TrieNode[2];
        }

        public boolean contains(int bit) {
            return links[bit] != null;
        }

        public TrieNode get(int bit) {
            return links[bit];
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(int num) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.contains(bit))
                    node.links[bit] = new TrieNode();
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
}