import Common.ListNode;

/*
 * https://leetcode.com/problems/reverse-linked-list/
 * O(n) time | O(n) space for recursive call stack
 */
public class ReverseALinkedList_Recursive {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode newHead = reverseListHelper(head);
        head.next = null;
        return newHead;
    }

    ListNode reverseListHelper(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseListHelper(head.next);
        head.next.next = head;
        return newHead;
    }
}
