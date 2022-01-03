import Common.ListNode;

/*
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * O(m + n) time | O(1) space - where m and n are lengths of two lists
 * This solution is concise but not necessarily optimal as there could be multiple cycles before both pointers meet
 */
public class IntersectionOfTwoLinkedLists_Clean {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = (nodeA == null) ? headA : nodeA.next;
            nodeB = (nodeB == null) ? headB : nodeB.next;
        }
        return nodeA;
    }
}
