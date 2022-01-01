import java.util.*;
import Common.*;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * O(n) time | O(n) space
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        boolean leftToRight = false;
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> leftToRightStack = new LinkedList<>();
        Deque<TreeNode> RightToLeftStack = new LinkedList<>();
        leftToRightStack.push(root);

        while(!leftToRightStack.isEmpty() || !RightToLeftStack.isEmpty()) {
            Deque<TreeNode> stack = leftToRightStack.isEmpty() ? RightToLeftStack : leftToRightStack;

            List<Integer> intermediate = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                intermediate.add(node.val);

                if (leftToRight) {
                    if (node.right != null)
                        leftToRightStack.push(node.right);

                    if (node.left != null)
                        leftToRightStack.push(node.left);

                }
                else {
                    if (node.left != null)
                        RightToLeftStack.push(node.left);

                    if (node.right != null)
                        RightToLeftStack.push(node.right);
                }
            }
            leftToRight = !leftToRight;
            result.add(intermediate);
        }
        return result;
    }
}
