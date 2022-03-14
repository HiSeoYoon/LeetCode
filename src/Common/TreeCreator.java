package Common;

import Common.Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeCreator {
    public static TreeNode createTree(String s) {
        String[] splitS = s.split(",");
//        System.out.println(Arrays.toString(splitS));

        List<TreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i < splitS.length; i++) {
            TreeNode node = null;
            if (!splitS[i].equals("null")) node = new TreeNode(Integer.parseInt(splitS[i]));
            nodeList.add(node);
        }

        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i) != null) addChild(i, nodeList);
        }

        return nodeList.get(0);
    }

    private static void addChild(int parentLoc, List<TreeNode> allNodeList) {
        int leftChildLoc = parentLoc * 2 + 1;
        int rightChildLoc = parentLoc * 2 + 2;

        TreeNode parent = allNodeList.get(parentLoc);
        if (leftChildLoc < allNodeList.size()) parent.setLeft(allNodeList.get(leftChildLoc));
        if (rightChildLoc < allNodeList.size()) parent.setRight(allNodeList.get(rightChildLoc));
    }
}
