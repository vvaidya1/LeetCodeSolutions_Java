import Common.TreeNode;

/*
 * https://leetcode.com/problems/path-sum/
 * O(n) time | O(log.n) space
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return pathSumHelper(root, 0, targetSum);
    }

    boolean pathSumHelper(TreeNode root, int currSum, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val + currSum == targetSum) {
            return true;
        }

        return pathSumHelper(root.left, currSum + root.val, targetSum) || pathSumHelper(root.right, currSum + root.val, targetSum);
    }
}
