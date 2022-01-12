import Common.ListNode;

/*
 * https://leetcode.com/problems/add-two-numbers/
 * O(m + n) time | O(m + n) space
 */
public class AddTwoNumbers_LinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode curr1 = l1, curr2 = l2, head = null, node = null;
        int sum, carry = 0, val;
        while (curr1 != null && curr2 != null) {
            sum = (curr1.val + curr2.val + carry);
            val = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = node = newNode;
            } else {
                node.next = newNode;
                node = node.next;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        if (curr1 == null)
            node.next = createRemainingList(curr2, carry);

        if (curr2 == null)
            node.next = createRemainingList(curr1, carry);

        return head;
    }

    public ListNode createRemainingList(ListNode curr, int carry) {
        int sum, val;
        ListNode node = null, head = null;
        while (curr != null) {
            sum = curr.val + carry;
            carry = sum / 10;
            val = sum % 10;

            ListNode newNode = new ListNode(val);
            if (head == null)
                head = node = newNode;
            else {
                node.next = newNode;
                node = node.next;
            }
            curr = curr.next;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            if (node == null)
                node = newNode;
            else
                node.next = newNode;
        }

        return head != null ? head : node;
    }
}
