/*
面试题37. 序列化二叉树

请实现两个函数，分别用来序列化和反序列化二叉树。

示例: 

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
 */

/*
笔记：

题目要分析清，[1,null,2,null,3,null,4] 表示的是：

     1
      \
       2
        \
         3
          \
           4

也就是说只有不为 null 的节点，才需要序列化它的子节点
*/

package com.zouxxyy;

import java.util.LinkedList;
import java.util.Queue;

public class Solution37 {
    public class Codec {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        // Your Codec object will be instantiated and called as such:
        // Codec codec = new Codec();
        // codec.deserialize(codec.serialize(root));

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "[]";
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            StringBuilder builder = new StringBuilder();
            builder.append('[');
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    builder.append("null,");
                } else {
                    builder.append(poll.val).append(',');
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
            return builder.deleteCharAt(builder.length() - 1).append(']').toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]")) return null;
            String[] split = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(split[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int cur = 1;
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (!split[cur].equals("null")) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(split[cur]));
                    poll.left = leftNode;
                    queue.add(leftNode);
                }
                cur++;
                if (!split[cur].equals("null")) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(split[cur]));
                    poll.right = rightNode;
                    queue.add(rightNode);
                }
                cur++;
            }
            return root;
        }
    }
}
