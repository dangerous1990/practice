package org.learn.leetcode.tree;

/**
 * Created by Administrator on 2016/11/3.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (sum == root.val && root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null) {
            boolean isLeft = hasPathSum(root.left, sum - root.val);
            if (isLeft) {
                return isLeft;
            }
        }
        if (root.left != null) {
            boolean isLeft = hasPathSum(root.right, sum - root.val);
            if (isLeft) {
                return isLeft;
            }
        }
        return false;
    }
}
