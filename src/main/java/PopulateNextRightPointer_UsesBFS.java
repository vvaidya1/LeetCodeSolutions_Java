import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * O(n) time | O(n) space where n is number of nodes in the tree
 */
public class PopulateNextRightPointer_UsesBFS {
    public Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node prev = null;
            while (size > 0) {
                Node node = queue.poll();
                node.next = prev;
                prev = node;

                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
                size--;
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}