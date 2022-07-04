package S0110_Balanced_Binary_Tree;

import Common.Node.TreeNode;
import Common.TreeCreator;

public class Solution {
    public static void main(String[] args) {
        TreeNode input = TreeCreator.createTree("3,9,20,null,null,15,7");
        boolean output = isBalanced(input);
        System.out.println(output);
    }

    private static int height(TreeNode root) {
        // An empty tree has height -1
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean isBalanced(TreeNode root) {
        // An empty tree satisfies the definition of a balanced tree
        if (root == null) {
            return true;
        }

        // Check if subtrees have height within 1. If they do, check if the
        // subtrees are balanced
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
}
