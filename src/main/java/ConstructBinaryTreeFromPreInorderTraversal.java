import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * O(n) time | O(n) space
 */
public class ConstructBinaryTreeFromPreInorderTraversal {
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        initInorderIndexMap(inorder);
        return buildTreeHelper(preorder, 0, preorder.length - 1);
    }

    TreeNode buildTreeHelper(int[] preorder, int start, int end) {
        if (start > end)
            return null;

        int rootVal = preorder[preorderIndex++];
        int index = inorderIndexMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(preorder, start, index - 1);
        root.right = buildTreeHelper(preorder, index + 1, end);

        return root;
    }

    void initInorderIndexMap(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
    }
}
