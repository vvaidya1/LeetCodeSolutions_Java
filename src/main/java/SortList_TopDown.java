import Common.ListNode;

/*
 * https://leetcode.com/problems/sort-list/
 * O(n.log.n) time | O(log.n) space
 */
public class SortList_TopDown {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode getMid(ListNode head) {
        ListNode prev = null, mid;
        while (head != null && head.next != null) {
            prev = (prev == null) ? head : prev.next;
            head = head.next.next;
        }
        mid = prev.next;
        prev.next = null;
        return mid;
    }

    ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;

            }
            prev = prev.next;
        }
        prev.next = (list1 == null) ? list2 : list1;
        return dummy.next;
    }
}
