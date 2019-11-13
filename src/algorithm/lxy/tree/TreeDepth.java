package algorithm.lxy.tree;

import algorithm.TreeNode;

/**
 * @author liuxinyi
 * @since 2019/11/13
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int nleft = TreeDepth(root.left);
        int nright = TreeDepth(root.right);

        return nleft > nright ? (nleft + 1) : (nright + 1);
    }
}
