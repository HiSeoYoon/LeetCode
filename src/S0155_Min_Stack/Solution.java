package S0155_Min_Stack;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }
}

class MinStack {
    private Stack<int[]> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
            return;
        }

        int currentMin = stack.peek()[1];
        stack.push(new int[]{val, Math.min(val, currentMin)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

class MinStack_2 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack_2() {
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
