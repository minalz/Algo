package cn.minalz.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树的前序遍历
 * @author: minalz
 * @date: 2021-05-25 22:21
 **/
public class PreOrderTree {

    /**
     * 递归方式
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode1 root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;
    }

    /**
     * 非递归方式
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode1 root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode1> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode1 node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}


// Definition for a binary tree node.
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1() {
    }

    TreeNode1(int val) {
        this.val = val;
    }

    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}