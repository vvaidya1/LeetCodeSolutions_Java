import Common.TreeNode;

import java.util.*;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * O(n) time | O(n) space
 */
public class LowestCommonAncestorOfBinaryTree_Iterative {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        parent.put(root, null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                stack.push(node.left);
                parent.put(node.left, node);
            }

            if (node.right != null) {
                stack.push(node.right);
                parent.put(node.right, node);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q))
            q = parent.get(q);

        return q;
    }
}
