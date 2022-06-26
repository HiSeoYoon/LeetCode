package S0009_Palindrome_Number;

public class Solution {
    public static void main(String[] args) {
        boolean output = IsPalindrome(121);
        System.out.println(output);
    }

    public static boolean IsPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
