import java.util.*;

class Trie_UsesMap {
    Map<Character, Trie_UsesMap> children;
    char X = 'X';

    public Trie_UsesMap() {
        children = new HashMap<>();
    }

    public void insert(String word) {
        Trie_UsesMap pointer = this;
        for (char ch : word.toCharArray()) {
            if (pointer.children.containsKey(ch))
                pointer = pointer.children.get(ch);
            else {
                Trie_UsesMap value = new Trie_UsesMap();
                pointer.children.put(ch, value);
                pointer = value;
            }
        }
        pointer.children.put(X, null);
    }

    public boolean search(String word) {
        Trie_UsesMap pointer = this;
        for (char ch : word.toCharArray()) {
            if (!pointer.children.containsKey(ch))
                return false;
            else
                pointer = pointer.children.get(ch);
        }
        return pointer.children.containsKey(X);
    }

    public boolean startsWith(String prefix) {
        Trie_UsesMap pointer = this;
        for (char ch : prefix.toCharArray()) {
            if (!pointer.children.containsKey(ch))
                return false;
            else
                pointer = pointer.children.get(ch);
        }
        return true;
    }
}

/*
 * Your Trie_UsesMap object will be instantiated and called as such:
 * Trie_UsesMap obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */