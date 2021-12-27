import java.util.*;
import Common.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * O(n) time | O(n) space - actually O(2^h) where h is the height of the tree
 * For a balanced tree h = log.n so O(2^(log.n)) will result in O(n)
 */
public class BinaryTreeLevelOrderTraversal {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null)
                return new ArrayList<>();

            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                List<Integer> list = new ArrayList<>();
                while (size > 0) {
                    size--;
                    TreeNode node = queue.poll();
                    list.add(node.val);

                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
                result.add(list);
            }
            return result;
        }
    }
}
