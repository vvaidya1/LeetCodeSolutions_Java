import Common.ListNode;

/*
 * https://leetcode.com/problems/reverse-linked-list/
 * O(n) time | O(1) space
 */
public class ReverseALinkedList_Iterative {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;

        ListNode node = head, prev = null;
        while (node.next != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        node.next = prev;
        return node;
    }
}
