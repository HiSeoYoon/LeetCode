package S0171_Excel_Sheet_Column_Number;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "AB";
        int output = titleToNumber(s);
        System.out.println(output);
    }

    public static int titleToNumber(String s) {
        int result = 0;

        Map<Character, Integer> alpha_map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int c = i + 65; // Decimal 65 in ASCII corresponds to char 'A'
            alpha_map.put((char) c, i + 1);
        }

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char cur_char = s.charAt(n - 1 - i);
            result += (alpha_map.get(cur_char) * (Math.pow(26, i)));
        }
        return result;
    }
}
