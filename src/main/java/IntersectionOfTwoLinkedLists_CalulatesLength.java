import Common.ListNode;

/*
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * O(m + n) time | O(1) space - where m and n are lengths of two lists
 */
public class IntersectionOfTwoLinkedLists_CalulatesLength {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int listALength = getLength(headA);
        int listBLength = getLength(headB);

        int d = Math.abs(listALength - listBLength), i = 0;
        ListNode node1 = listALength >= listBLength ? headA : headB;
        ListNode node2 = listALength >= listBLength ? headB : headA;

        while (i++ < d) {
            node1 = node1.next;
        }

        while (node1 != null && node2 != null) {
            if (node1 == node2)
                return node1;
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }

    int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count += 1;
        }
        return count;
    }
}
