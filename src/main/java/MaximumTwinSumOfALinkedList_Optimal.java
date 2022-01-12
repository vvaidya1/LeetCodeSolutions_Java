import Common.ListNode;

/*
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 * O(n) time | O(1) space
 */
public class MaximumTwinSumOfALinkedList_Optimal {
    public int pairSum(ListNode head) {
        if (head == null)
            return 0;

        int length = getLength(head);
        ListNode node = head;
        int i = 0;
        while (i < length / 2) {
            node = node.next;
            i++;
        }

        ListNode head1 = head, head2 = reverseList(node);
        int maxSum = 0;
        while (head1 != null && head2 != null) {
            maxSum = Math.max(maxSum, head1.val + head2.val);
            head1 = head1.next;
            head2 = head2.next;
        }
        return maxSum;
    }

    int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode curr = head, prev = null;
        while (curr.next != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;
        return curr;
    }
}
