import Common.ListNode;

/*
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * O(min(m,n)) time | O(min(m,n)) space where m and n are the number of elements in the input lists
 */
public class MergeTwoSortedLists_Recursive {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        if (list1.val <= list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        }
        else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }
}
