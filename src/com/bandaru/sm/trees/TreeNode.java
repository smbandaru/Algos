package com.bandaru.sm.trees;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int value) {
        this.value = value;
    }

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

