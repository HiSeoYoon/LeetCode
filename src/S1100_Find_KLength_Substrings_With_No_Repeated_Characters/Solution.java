package S1100_Find_KLength_Substrings_With_No_Repeated_Characters;

public class Solution {
    public static void main(String[] args) {
        String input = "havefunonleetcode";
        numKLenSubstrNoRepeats(input, 5);
    }

    public static int numKLenSubstrNoRepeats(String s, int k) {
        if (k > 26)
            return 0;
        int n = s.length();
        int answer = 0;

        for (int i = 0; i <= n - k; i++) {
            int freq[] = new int[26];
            boolean isUnique = true;

            for (int j = i; j < i + k; j++) {
                char ch = s.charAt(j);

                freq[ch - 'a']++;

                if (freq[ch - 'a'] > 1) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                answer++;
            }
        }
        return answer;
    }
}
