package S0104_Maximum_Depth_of_Binary_Tree;

import Common.Node.TreeNode;
import Common.TreeCreator;

public class Solution {
    public static void main(String[] args) {
        TreeNode input = TreeCreator.createTree("3,9,20,null,null,15,7");
        int output = maxDepth(input);
        System.out.println(output);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }
}
