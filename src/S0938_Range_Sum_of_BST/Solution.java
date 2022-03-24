package S0938_Range_Sum_of_BST;

import Common.Node.TreeNode;
import Common.TreeCreator;

public class Solution {
    public static void main(String[] args) {
        TreeNode input = TreeCreator.createTree("10,5,15,3,7,null,18");
        int output = rangeSumBST(input, 7, 15);
        System.out.println(output);
    }

    static int retVal;

    public static int rangeSumBST(TreeNode root, int low, int hig) {
        retVal = 0;
        dfs(root, low, hig);
        return retVal;
    }

    public static void dfs(TreeNode root, int left, int right) {
        if (root != null) {
            if (left <= root.val && root.val <= right) {
                retVal += root.val;
            }
            if (left < root.val) {
                dfs(root.left, left, right);
            }
            if (root.val < right) {
                dfs(root.right, left, right);
            }
        }
    }
}
