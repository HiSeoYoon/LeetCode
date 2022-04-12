package S0257_Binary_Tree_Paths;

import Common.Node.TreeNode;
import Common.TreeCreator;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode input = TreeCreator.createTree("1,2,3,null,5");
        binaryTreePaths(input);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        construct_paths(root, "", paths);
        return paths;
    }

    public static void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null)) {
                paths.add(path);
            } else {
                path += "->";
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }


}
