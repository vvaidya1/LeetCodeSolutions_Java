public class Trie_Optimal {
    private final TrieNode root;

    public Trie_Optimal() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            if (!currentNode.contains(ch)) {
                currentNode.put(ch);
            }
            currentNode = currentNode.get(ch);
        }
        currentNode.setEnd();
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            if (!currentNode.contains(ch))
                return false;
            currentNode = currentNode.get(ch);
        }

        return currentNode.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (char ch : prefix.toCharArray()) {
            if (!currentNode.contains(ch))
                return false;
            currentNode = currentNode.get(ch);
        }
        return true;
    }
}

class TrieNode {
    final int N = 26;
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[N];
    }

    boolean contains(char ch) {
        return children[ch - 'a'] != null;
    }

    TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    void put(char ch) {
        TrieNode node = new TrieNode();
        children[ch - 'a'] = node;
    }

    boolean isEnd() {
        return isEnd;
    }

    void setEnd() {
        isEnd = true;
    }
}

/*
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */