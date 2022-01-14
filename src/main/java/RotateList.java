import Common.ListNode;

/*
 * https://leetcode.com/problems/rotate-list/
 * O(n) time | O(1) space
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0)
            return head;

        int length = 0;
        ListNode curr = head, end = null, newHed = null, prev = null;
        while (curr != null) {
            end = curr;
            curr = curr.next;
            length++;
        }

        curr = head;
        for (int i = 0; i < length - (k % length); i++) {
            prev = curr;
            curr = curr.next;
        }
        end.next = head;
        if (prev != null)
            prev.next = null;

        return curr == null ? head : curr;
    }
}
