package S0101_Symmetric_Tree;

import Common.Node.TreeNode;
import Common.TreeCreator;

public class Solution {
    public static void main(String[] args) {
        TreeNode input = TreeCreator.createTree("1,2,2,3,4,4,3");
        isSymmetric(input);
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
