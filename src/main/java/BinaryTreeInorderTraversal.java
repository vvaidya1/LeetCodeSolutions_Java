import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        inorderTraversalHelper(root, result);
        return result;
    }

    void inorderTraversalHelper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);
    }
}
