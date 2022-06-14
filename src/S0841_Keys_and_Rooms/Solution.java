package S0841_Keys_and_Rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        while (!stack.isEmpty()) { // While we have keys...
            int node = stack.pop(); // Get the next key 'node'
            for (int nei : rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the todo list
                }
        }

        for (boolean v : seen)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }

}
