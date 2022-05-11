package S0227_Basic_Calculator_2;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String input = "1+3*5";
        System.out.println(calculate(input));
    }

    public static int calculate(String s) {

        if (s == null || s.isEmpty()) return 0;
        int len = s.length();

        Stack<Integer> numsStack = new Stack<>();

        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    numsStack.push(-currentNumber);
                } else if (operation == '+') {
                    numsStack.push(currentNumber);
                } else if (operation == '*') {
                    numsStack.push(numsStack.pop() * currentNumber);
                } else if (operation == '/') {
                    numsStack.push(numsStack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!numsStack.isEmpty()) {
            result += numsStack.pop();
        }
        return result;
    }
}
