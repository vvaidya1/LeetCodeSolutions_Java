import Common.ListNode;

/*
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * O(n) time | O(log.k-base.n) space - space due to recursion
 */
public class ReverseNodesInKGroups_Optimal {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        return reverseKList(head, k);
    }

    ListNode reverseKList(ListNode head, int k) {
        int length = getLength(head);

        if (length >= k)
            return reverse(head, k);
        else
            return head;
    }

    int getLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    ListNode reverse(ListNode head, int k) {
        ListNode node = head, prev = null;
        int i = 0;

        while (node != null && i < k) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            i++;
        }

        if (node != null)
            head.next = reverseKList(node, k);
        return prev;
    }
}
