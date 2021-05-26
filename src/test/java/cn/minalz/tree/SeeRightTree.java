package cn.minalz.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* @description: 199.二叉树的右视图
* @author:minalz
* @date:2021-05-26 22:45
*/
public class SeeRightTree {

    public List<Integer> rightSideView(TreeNode4 root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode4> queue = new LinkedList<>();
        queue.offer(root);
        boolean findRight = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            findRight = false;
            for (int i = 0; i < size; i++) {
                TreeNode4 node = queue.poll();
                if (!findRight) {
                    result.add(node.val);
                    findRight = true;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return result;
    }
}


//  Definition for a binary tree node.
class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;

    TreeNode4() {
    }

    TreeNode4(int val) {
        this.val = val;
    }

    TreeNode4(int val, TreeNode4 left, TreeNode4 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
