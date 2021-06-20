package com.bandaru.sm.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversals {
    public static void main(String[] args) {
        TreeNode tree = TreeUtils.buildTree(3, 9, 20, 6, 8, 15, 7);
        List<Integer> result = new ArrayList<Integer>();

        preOrder(tree, result);
        System.out.println(result);
        result.clear();

        inOrder(tree, result);
        System.out.println(result);
        result.clear();

        postOrder(tree, result);
        System.out.println(result);
        result.clear();
    }

    public static void preOrder(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        result.add(node.value);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    public static void inOrder(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        inOrder(node.left, result);
        result.add(node.value);
        inOrder(node.right, result);
    }

    public static void postOrder(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        postOrder(node.left, result);
        postOrder(node.right, result);
        result.add(node.value);
    }
}
