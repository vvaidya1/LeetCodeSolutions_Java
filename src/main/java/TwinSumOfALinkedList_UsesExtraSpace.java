import Common.ListNode;

/*
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 * O(n) time | O(n) space
 */
public class TwinSumOfALinkedList_UsesExtraSpace {
    public int pairSum(ListNode head) {
        if (head == null)
            return 0;

        int length = getLength(head), maxSum = 0;
        int[] twinSum = new int[length / 2];

        int i = 0;
        ListNode current = head;
        while (current != null && i < length) {
            if (i < length / 2)
                twinSum[i] += current.val;
            else
                twinSum[length - 1 - i] += current.val;
            i++;
            current = current.next;
        }

        for (int num: twinSum) {
            maxSum = Math.max(maxSum, num);
        }
        return maxSum;
    }

    int getLength(ListNode head) {
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        return length;
    }
}
