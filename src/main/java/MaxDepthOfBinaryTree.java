import Common.TreeNode;

/*
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * O(n) time complexity | O(h) space
 */
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

