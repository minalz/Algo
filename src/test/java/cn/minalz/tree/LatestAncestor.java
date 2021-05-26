package cn.minalz.tree;

/**
 * @description: 236. 二叉树的最近公共祖先
 * @author: minalz
 * @date: 2021-05-26 23:03
 **/
public class LatestAncestor {

    public TreeNode5 lowestCommonAncestor(TreeNode5 root, TreeNode5 p, TreeNode5 q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode5 left = lowestCommonAncestor(root.left, p, q);
        TreeNode5 right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}

//  Definition for a binary tree node.
class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;

    TreeNode5(int x) {
        val = x;
    }
}
