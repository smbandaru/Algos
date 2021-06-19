package com.bandaru.sm.trees;

public class ValidateBST {
    public static void main(String[] args) {
        System.out.println(isValidBST(TreeUtils.buildTree(5, 4, 6, null, null, 3, 7)));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return checkIfBST(root.left, ((long) Integer.MIN_VALUE) - 1, root.value) && checkIfBST(root.right, root.value, ((long) Integer.MAX_VALUE) + 1);
    }

    private static boolean checkIfBST(TreeNode node, long min, long max) {
        if (node == null)
            return true;
        if (node.value <= min || node.value >= max)
            return false;
        return checkIfBST(node.left, min, node.value) && checkIfBST(node.right, node.value, max);
    }
}
