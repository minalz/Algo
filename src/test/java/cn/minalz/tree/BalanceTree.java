package cn.minalz.tree;

/**
 * @description: 110.平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * @author: minalz
 * @date: 2021-05-26 23:16
 **/
public class BalanceTree {

    public boolean isBalanced(TreeNode6 root) {
        if (root == null) {
            return true;
        }

        return maxTree(root) != -1;
    }

    public int maxTree(TreeNode6 node) {
        if (node == null) {
            return 0;
        }
        int left = maxTree(node.left);
        int right = maxTree(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}


// Definition for a binary tree node.
class TreeNode6 {
    int val;
    TreeNode6 left;
    TreeNode6 right;

    TreeNode6() {
    }

    TreeNode6(int val) {
        this.val = val;
    }

    TreeNode6(int val, TreeNode6 left, TreeNode6 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
