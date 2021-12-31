/*
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * O(n) time | O(n) space where n is number of nodes in the tree
 */
public class PopulateNextRightPointer_UsesDFS {
    public Node connect(Node root) {
        DFS(root, null);
        return root;
    }

    void DFS(Node root, Node next) {
        if (root == null)
            return;

        root.next = next;
        DFS(root.left, root.right);
        DFS(root.right, root.next != null ? root.next.left : null);
    }
}
