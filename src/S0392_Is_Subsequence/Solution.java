package S0392_Is_Subsequence;

public class Solution {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean output = isSubsequence(s, t);
        System.out.println(output);
    }

    public static boolean isSubsequence(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (0 > t.indexOf(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
