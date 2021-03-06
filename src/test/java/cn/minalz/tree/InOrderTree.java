package cn.minalz.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树的中序遍历
 * @author: minalz
 * @date: 2021-05-25 22:50
 **/
public class InOrderTree {

    /**
     * 递归方式
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode2 root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }

    /**
     * 非递归方式
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode2 root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode2> stack = new Stack<>();
        TreeNode2 current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }
    
}

// Definition for a binary tree node.
class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2() {
    }

    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}