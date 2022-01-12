import Common.ListNode;

/*
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * O(n) time | O(n) space
 */
public class ReverseNodesInKGroups_BruteForce {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        int length = getLength(head);
        int[] array = new int[length];

        copyLinkedListToArray(head, array);

        for (int i = 0; i <= length - k; i += k) {
            reverseSubArray(array, i, i + k - 1);
        }

        ListNode node = head;
        for (int j = 0; j < length; j++) {
            System.out.print(array[j] + " ");
            node.val = array[j];
            node = node.next;
        }

        return head;
    }

    void reverseSubArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }

    void copyLinkedListToArray(ListNode head, int[] array) {
        int i = 0;
        ListNode node = head;
        while (node != null) {
            array[i++] = node.val;
            node = node.next;
        }
    }

    int getLength(ListNode head) {
        int length = 0;
        ListNode node = head;

        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
