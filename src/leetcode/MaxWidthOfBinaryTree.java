package leetcode;

/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 * The maximum width of a tree is the maximum width among all levels.
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
 * It is guaranteed that the answer will in the range of a 32-bit signed integer.
 */

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */


public class MaxWidthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        queue.offer(root);
        indexQueue.offer(1);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int leftIndex = 0, rightIndex = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                int index = indexQueue.poll();

                if (i == 0) {
                    leftIndex = index;
                }
                if (i == levelSize - 1) {
                    rightIndex = index;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    indexQueue.offer(index * 2);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    indexQueue.offer(index * 2 + 1);
                }
            }
            maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
        }
        return maxWidth;
    }
}
