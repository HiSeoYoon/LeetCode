package S0094_Binary_Tree_Inorder_Traversal;

import Common.Node.TreeNode;
import Common.TreeCreator;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode input = TreeCreator.createTree("1,null,2,3");
        List<Integer> output = inorderTraversal(input);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }
}
