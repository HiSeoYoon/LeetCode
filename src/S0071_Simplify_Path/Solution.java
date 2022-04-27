package S0071_Simplify_Path;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        simplifyPath("/home/");
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(directory);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }
        return result.length() > 0 ? result.toString() : "/";
    }
}
