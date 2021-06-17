package com.bandaru.sm.trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTreeTraversal {
    public static void main(String[] args) {
        System.out.println(levelOrder(TreeUtils.buildTree(3, 9, 20, null, null, 15, 7)));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            List<Integer> ithLevel = new ArrayList<Integer>();
            TreeNode node = queue.remove();
            while (node != null) {
                ithLevel.add(node.value);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                node = queue.remove();
            }
            if (!queue.isEmpty())
                queue.add(null);
            result.add(ithLevel);
        }
        return result;
    }
}
