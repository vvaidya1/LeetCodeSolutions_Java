import Common.TreeNode;
import java.util.*;

/*
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserializeBinaryTree_Iterative {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder result = new StringBuilder();
            levelOrderTraversal(root, result);
            return result.toString();
        }

        void levelOrderTraversal(TreeNode root, StringBuilder result) {
            if (root == null) {
                result.append("[]");
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            result.append("[");
            while (!queue.isEmpty()) {
                int size = queue.size();

                while (size > 0) {
                    TreeNode node = queue.poll();

                    if (node == null)
                        result.append("null").append(",");
                    else {
                        result.append(node.val).append(",");
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                    size--;
                }
            }
            result.deleteCharAt(result.length()-1);
            result.append("]");
            System.out.println(result);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.equals("") || data.equals("[]"))
                return null;

            String[] input = data.replace("[", "").replace("]", "").split(",");
            TreeNode root = new TreeNode(Integer.parseInt(input[0]));

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            for (int i = 0; i <= input.length / 2; i++) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;

                Integer leftVal = input[2 * i + 1].equals("null") ? null : Integer.parseInt(input[2 * i + 1]);
                Integer rightVal = input[2 * i + 2].equals("null") ? null : Integer.parseInt(input[2 * i + 2]);

                if (leftVal == null)
                    node.left = null;
                else
                {
                    node.left = new TreeNode(leftVal);
                    queue.offer(node.left);
                }

                if (rightVal == null)
                    node.right = null;
                else {
                    node.right = new TreeNode(rightVal);
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
