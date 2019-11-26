package leetcode;

import algorithm.TreeNode;

import java.util.ArrayList;

/**
 * @author liuxinyi
 * @description 求给定的二叉树的前序遍历。中左右
 * @since 2019/11/26
 */
public class Number7 {
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}
