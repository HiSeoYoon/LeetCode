package S0392_Is_Subsequence;

public class Solution {
    public static void main(String[] args) {
        String s = "aaaabc";
        String t = "aabbcc";
        boolean output = isSubsequence(s, t);
        System.out.println(output);
    }

    public static boolean isSubsequence(String s, String t) {
        int prevIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int findIndex = t.indexOf(s.charAt((i)), prevIndex);
            if (0 > findIndex) {
                return false;
            }
            prevIndex = findIndex + 1;
        }
        return true;
    }
}
