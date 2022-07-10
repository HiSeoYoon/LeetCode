package S0168_Excel_Sheet_Column_Title;

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertToTitle(27));
    }

    public static String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
    }
}
