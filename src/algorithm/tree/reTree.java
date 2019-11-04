package algorithm.tree;

import algorithm.TreeNode;

/**
 * @author liuxinyi
 * @description 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @since 2019/11/4
 */
public class reTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length != in.length || pre == null || in == null) {
            return null;
        }
        return reConstructBinaryTree(pre, 0, in, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int k, int[] in, int begin, int end) {
        if (begin > end) {
            return null;
        }
        TreeNode head = new TreeNode(pre[k]);
        if (begin == end) {
            return head;
        }
        int j = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == head.val) {
                j = i;
                break;
            }
        }

        head.left = reConstructBinaryTree(pre, k + 1, in, begin, j - 1);
        head.right = reConstructBinaryTree(pre, k + (j + 1 - begin), in, j + 1, end);
        return head;
    }
}
