package leetcode;

import algorithm.TreeNode;

import java.util.ArrayList;

/**
 * @author liuxinyi
 * @description 求给定的二叉树的后序遍历。左右中
 * @since 2019/11/26
 */
public class Number6 {
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}
