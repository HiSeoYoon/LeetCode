package S0111_Minimum_Depth_of_Binary_Tree;

import Common.Node.TreeNode;
import Common.TreeCreator;

public class Solution {
    public static void main(String[] args) {
        TreeNode input = TreeCreator.createTree("-10,-3,0,5,9");

    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }
}
