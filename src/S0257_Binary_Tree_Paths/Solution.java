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

    public static List<String> binaryTreePaths2(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        if (root == null) {
            return paths;
        }

        LinkedList<TreeNode> node_stack = new LinkedList<>();
        LinkedList<String> path_stack = new LinkedList<>();
        node_stack.add(root);
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;

        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null))
                paths.add(path);
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return paths;
    }

}
