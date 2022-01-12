import Common.ListNode;

/*
 * https://leetcode.com/problems/linked-list-cycle/
 * O(n) time | O(1) space
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
}
