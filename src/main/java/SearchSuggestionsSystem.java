import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 * O(n.m) time | O(n.m) space - where n is the number of products and m is the average length of name of products
 */
public class SearchSuggestionsSystem {
    TrieNode root;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String product : products) {
            insert(product);
        }

        return search(searchWord);
    }

    private void insert(String product) {
        if (root == null)
            root = new TrieNode();
        TrieNode curr = root;
        for (char ch : product.toCharArray()) {
            int key = ch - 'a';
            if (curr.children[key] == null)
                curr.children[key] = new TrieNode();

            curr.children[key].suggestions.add(product);
            Collections.sort(curr.children[key].suggestions);

            if (curr.children[key].suggestions.size() > 3)
                curr.children[key].suggestions.pollLast();

            curr = curr.children[key];
        }
    }

    private List<List<String>> search(String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TrieNode curr = root;
        for (char ch : searchWord.toCharArray()) {
            int key = ch - 'a';
            result.add(curr == null || curr.children[key] == null ? new ArrayList<>() : curr.children[key].suggestions);

            if (curr != null)
                curr = curr.children[key];
        }
        return result;
    }

    class TrieNode {
        TrieNode[] children;
        LinkedList<String> suggestions;

        public TrieNode() {
            children = new TrieNode[26];
            suggestions = new LinkedList<>();
        }
    }
}