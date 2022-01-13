import Common.ListNode;

/*
 * https://leetcode.com/problems/palindrome-linked-list/
 * O(n) time | O(1) space
 * Note that below solution reverses first half of the list which will distort the structure of the list
 */
public class PalindromeLinkedList_ReverseFirstHalf {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            ListNode temp = prev;
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            prev.next = temp;
        }

        if (fast != null)
            slow = slow.next;

        while (prev != null) {
            if (prev.val != slow.val)
                return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}
