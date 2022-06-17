import Common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-cameras/
 * O(n) time | O(n) space - where n is the number of nodes in the tree
 * Reference https://www.youtube.com/watch?v=uoFrIIrp5_g
 */
public class BinaryTreeCameras {
    int cameras;

    public int minCameraCover(TreeNode root) {
        if (root == null)
            return 0;

        int rootStatus = dfs(root);
        return rootStatus == -1 ? cameras + 1 : cameras;
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 1;

        int leftStatus = dfs(root.left);
        int rightStatus = dfs(root.right);
        if (leftStatus == -1 || rightStatus == -1) {
            cameras++;
            return 0;
        }
        else if (leftStatus == 0 || rightStatus == 0)
            return 1;
        else
            return -1;
    }
}
