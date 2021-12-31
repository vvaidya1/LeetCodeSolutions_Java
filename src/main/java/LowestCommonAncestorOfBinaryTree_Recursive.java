import Common.TreeNode;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * O(n) time | O(n) space
 */
public class LowestCommonAncestorOfBinaryTree_Recursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return (left != null && right != null) ? root : (left == null ? right : left);
    }
}
