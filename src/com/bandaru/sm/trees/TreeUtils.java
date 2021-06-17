package com.bandaru.sm.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {
    public static TreeNode buildTree(Object... values) {
        if (values.length == 0)
            return null;

        TreeNode root = new TreeNode((int) values[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean leftFlag = true;
        for (int i = 1; i < values.length; i++) {
            TreeNode node = null;
            if (values[i] instanceof Integer) {
                node = new TreeNode((int) values[i]);
                queue.add(node);
            }

            TreeNode parent = queue.peek();
            if (leftFlag) {
                parent.left = node;
                leftFlag = false;

            } else {
                parent.right = node;
                queue.remove();
                leftFlag = true;
            }
        }
        return root;
    }
}
