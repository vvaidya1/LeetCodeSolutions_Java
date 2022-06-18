/**
 * https://leetcode.com/problems/prefix-and-suffix-search/
 */
public class PrefixAndSuffixSearch {
    TrieNode root;

    //public WordFilter(String[] words) {
    public PrefixAndSuffixSearch(String[] words) {
        root = new TrieNode();
        for (int index = 0; index < words.length; index++) {
            String word = "{" + words[index];
            insert(word, index);
            for (int i = 0; i < words[index].length(); i++) {
                insert(word.substring(i + 1) + word, index);
            }
        }
    }

    void insert(String word, int index) {
        TrieNode node = root;
        for (char chr : word.toCharArray()) {
            int key = chr - 'a';
            if (node.children[key] == null)
                node.children[key] = new TrieNode();
            node.children[key].index = index;
            node = node.children[key];
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode node = root;
        for (char chr : (suffix + "{" + prefix).toCharArray()) {
            if (node.children[chr - 'a'] == null)
                return -1;
            node = node.children[chr - 'a'];
        }
        return node.index;
    }

    class TrieNode {
        TrieNode[] children;
        int index;

        public TrieNode() {
            children = new TrieNode[27];
            index = -1;
        }
    }
}