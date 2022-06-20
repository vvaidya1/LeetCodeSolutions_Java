import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/short-encoding-of-words/
 * O(m.n) time | O(m.n) space - where n is the number of words and m is the average length of words
 */
public class ShortEncodingOfWords_UsesTrie {
    TrieNode root = new TrieNode('r');
    Set<TrieNode> set = new HashSet<>();

    public int minimumLengthEncoding(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int key = word.charAt(i) - 'a';
                if (node.children[key] == null) {
                    node.children[key] = new TrieNode(word.charAt(i));
                }
                node.numChildren++;
                node.children[key].height = node.height + 1;
                node = node.children[key];
                set.add(node);
            }
        }

        int res = 0;
        for (TrieNode node : set) {
            if (node.numChildren == 0)
                res += node.height + 1;
        }
        return res;
    }

    class TrieNode {
        TrieNode[] children;
        int height;
        int numChildren;

        public TrieNode(char c) {
            children = new TrieNode[26];
            height = 0;
            numChildren = 0;
        }
    }
}