package S0125_Valid_Palindrome;

import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        boolean output = isPalindrome(input);
        System.out.println(output);
    }

    public static boolean isPalindrome(String s){
        s = s.trim();
        s = s.toLowerCase();
        s = s.replace("[^a-z]", "");

        char[] chs = s.toCharArray();

        for(int i = 0; i<Math.floor(chs.length / 2); i++)
        {
            if(Character.compare(chs[i], chs[chs.length - i -1]) != 0)
            {
                return false;
            }
        }

        return true;
    }
}
