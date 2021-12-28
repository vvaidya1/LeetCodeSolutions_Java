import Common.ListNode;

/*
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * O(min(m,n)) time | O(1) space where m and n are the number of elements in the input lists
 */
public class MergeTwoSortedLists_Iterative {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        ListNode currOne = list1, currTwo = list2, head = new ListNode(), curr = head;
        while (currOne != null && currTwo != null) {
            curr.next = (currOne.val <= currTwo.val) ? currOne : currTwo;
            curr = curr.next;

            if (currOne.val <= currTwo.val)
                currOne = currOne.next;
            else
                currTwo = currTwo.next;
        }

        if (currOne == null)
            curr.next = currTwo;
        else
            curr.next = currOne;

        return head.next;
    }
}
