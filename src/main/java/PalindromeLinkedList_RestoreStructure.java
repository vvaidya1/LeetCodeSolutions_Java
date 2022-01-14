import Common.ListNode;

/*
 * https://leetcode.com/problems/palindrome-linked-list/
 * O(n) time | O(1) space
 */
public class PalindromeLinkedList_RestoreStructure {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        ListNode slow = head, fast = head, rev = null;
        while (fast != null && fast.next != null) {
            ListNode temp = rev;
            rev = slow;
            slow = slow.next;
            fast = fast.next.next;
            rev.next = temp;
        }

        ListNode tail = (fast != null) ? slow.next : slow;
        while (rev != null) {
            if (tail.val != rev.val)
                return false;
            ListNode temp = slow;
            slow = rev;
            rev = rev.next;
            tail = tail.next;
            slow.next = temp;
        }
        return true;
    }
}
