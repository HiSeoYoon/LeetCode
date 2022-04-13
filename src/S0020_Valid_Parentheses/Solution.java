package S0020_Valid_Parentheses;

public class Solution {
    public static void main(String[] args) {
        String input = "()(}";
        System.out.println(isValid(input));
    }

    public static boolean isValid(String s) {
        char smallPar = ')';
        char middlePar = '}';
        char largePar = ']';

        int findIndex = 0;

        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {
                case '(':
                    findIndex = s.indexOf(smallPar, findIndex + 1);
                    if (findIndex < 0) {
                        return false;
                    }
                case '{':
                    findIndex = s.indexOf(middlePar, findIndex + 1);
                    if (findIndex < 0) {
                        return false;
                    }
                case '[':
                    findIndex = s.indexOf(largePar, findIndex + 1);
                    if (findIndex < 0) {
                        return false;
                    }
                default:
                    continue;
            }
        }

        return true;
    }
}
