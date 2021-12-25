import Common.TreeNode;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * O(h+k) time | O(h) space for recursion stack
 */
public class KthSmallestElementBst {
    public int kthSmallest(TreeNode root, int k) {
        TreeInfo treeInfo = new TreeInfo(-1, 0);
        inorderTraversalForKSmallest(root, k, treeInfo);
        return treeInfo.value;
    }

    void inorderTraversalForKSmallest(TreeNode root, int k, TreeInfo treeInfo) {
        if (root == null || treeInfo.numVisitedNodes >= k)
            return;

        inorderTraversalForKSmallest(root.left, k, treeInfo);
        if (treeInfo.numVisitedNodes < k) {
            treeInfo.numVisitedNodes += 1;
            treeInfo.value = root.val;
            inorderTraversalForKSmallest(root.right, k, treeInfo);
        }
    }
}

class TreeInfo {
    int value;
    int numVisitedNodes;

    public TreeInfo(int val, int position) {
        this.value = val;
        this.numVisitedNodes = position;
    }
}