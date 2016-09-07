package org.learn.leetcode;

/**
 * Created by Administrator on 2016/9/7.
 */
public class MaximumDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {
        //Base case: if root is null, return 0
        if(root==null)
            return 0;

        //General case: if 1 or more nodes are present
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }


}
