package S0543_Diameter_of_Binary_Tree;

import com.sun.source.tree.Tree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode input = new TreeNode(1);//1,2,3,4,5);//[1,2,3,4,5];
        input.left = new TreeNode(2);
        input.right = new TreeNode(3);
        input.left.left = new TreeNode(4);
        input.left.right = new TreeNode(5);

        //int output =

    }

      //Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static int diameterOfBinaryTree(TreeNode root){
        int distanceVal = 0;

        //while()
        return distanceVal;
    }

    public static int existLeftTree(TreeNode root){
        if(root.left == null){
            return 0;
        }
        return 1;
    }
    public static int existRightTree(TreeNode root){
        if(root.right == null){
            return 0;
        }
        return 1;
    }

}
