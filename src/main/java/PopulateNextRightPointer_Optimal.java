/*
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * O(n) time | O(1) space where n is number of nodes in the tree
 */
public class PopulateNextRightPointer_Optimal {
    public Node connect(Node root) {
        if (root == null)
            return null;

        Node parent = root, current;
        while (parent.left != null) {
            current = parent;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null)
                    current.right.next = current.next.left;
                current = current.next;
            }
            parent = parent.left;
        }
        return root;
    }
}
