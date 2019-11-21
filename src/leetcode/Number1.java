package leetcode;

import algorithm.TreeNode;

/**
 * @author liuxinyi
 * @description 求给定二叉树的最小深度。
 * 最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 * @since 2019/11/19
 */
public class Number1 {
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null || root.right == null) {
            return Math.max(run(root.left), run(root.right)) + 1;
        }
        return Math.min(run(root.left), run(root.right)) + 1;
    }
}
