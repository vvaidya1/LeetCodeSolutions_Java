import Common.TreeNode;

/*
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * O(n) time | O(log.n) where n is the length of input array
 */
public class SortedArrayToBST_Recursive {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTHelper(nums, start, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, end);
        return node;
    }
}
