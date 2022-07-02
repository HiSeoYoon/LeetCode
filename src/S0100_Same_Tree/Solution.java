package S0100_Same_Tree;

import Common.Node.TreeNode;
import Common.TreeCreator;

public class Solution {
    public static void main(String[] args) {
        TreeNode pInput = TreeCreator.createTree("1,2,3");
        TreeNode qInput = TreeCreator.createTree("1,2,3");
        boolean output = isSameTree(pInput, qInput);
        System.out.println(output);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }
}
