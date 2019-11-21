package leetcode;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuxinyi
 * @description 给定一个二叉树，返回该二叉树的之字形层序遍历，（从左向右，下一层从右向左，一直这样交替）
 * @since 2019/11/21
 */
public class Number103 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode lastNode = root, levelLastNode = root;
        ArrayList<Integer> temp = new ArrayList<>();
        int flag = 0;
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            temp.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                lastNode = node.left;
            }
            if (node.right != null) {
                queue.add(node.right);
                lastNode = node.right;
            }
            if (node == levelLastNode) {
                levelLastNode = lastNode;
                if (flag % 2 != 0) {
                    Collections.reverse(temp);
                }
                result.add(new ArrayList<>(temp));
                temp.clear();
                flag++;
            }
        }
        return result;
    }
}
