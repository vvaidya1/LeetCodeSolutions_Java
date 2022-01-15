
/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * O(n) time | O(1) space
 */
public class CloneListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val);
            Node temp = node.next;
            node.next = newNode;
            newNode.next = temp;
            node = node.next.next;
        }

        node = head;
        while (node != null && node.next != null) {
            node.next.random = node.random != null ? node.random.next : null;
            node = node.next.next;
        }

        Node orig = head, newHead = head.next, clone = newHead;
        while (orig != null && orig.next != null) {
            orig.next = orig.next.next;
            clone.next = (clone.next != null) ? clone.next.next : null;
            orig = orig.next;
            clone = clone.next;
        }
        return newHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}