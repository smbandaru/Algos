package com.bandaru.sm.trees;

import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        System.out.println(isBalanced(TreeUtils.buildTree(3, 9, 20, null, null, 15, 7)));
        System.out.println(isBalanced(TreeUtils.buildTree(1, 2, 2, 3, 3, null, null, 4, 4)));
    }

    public static boolean isBalanced(TreeNode root) {
        Map<TreeNode, Integer> heights = new HashMap<TreeNode, Integer>();
        heightOfTree(root, heights);
        return isBalancedAtNode(root, heights);
    }

    private static boolean isBalancedAtNode(TreeNode node, Map<TreeNode, Integer> heights) {
        if (node == null)
            return true;
        if (Math.abs(heights.get(node.left) - heights.get(node.right)) > 1)
            return false;
        return isBalancedAtNode(node.left, heights) && isBalancedAtNode(node.right, heights);
    }

    public static int heightOfTree(TreeNode node, Map<TreeNode, Integer> heights) {
        if (node == null) {
            heights.put(node, 0);
            return 0;
        }
        if (heights.containsKey(node)) {
            return heights.get(node);
        } else {
            int height = 1 + Math.max(heightOfTree(node.left, heights), heightOfTree(node.right, heights));
            heights.put(node, height);
            return height;
        }
    }
}

