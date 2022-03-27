package S0226_Invert_Binary_Tree;

import Common.Node.TreeNode;
import Common.TreeCreator;

public class Solution {
    public static void main(String[] args) {
        TreeNode input = TreeCreator.createTree("10,5,15,3,7,12,17,1,4,6,9,11,13,16,20");//4,2,7,1,3,6,9");
        TreeNode output = invertTree(input);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        if (right != null && left != null) {
            System.out.println(root.right.val);
            System.out.println(root.left.val);
        }

        return root;
    }
}
