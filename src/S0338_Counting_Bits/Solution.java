package S0338_Counting_Bits;

public class Solution {
    public static void main(String[] args) {
        int[] output = countBits(5);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    private static int popCount(int x) {
        int count;
        for (count = 0; x != 0; ++count) {
            x &= x - 1;
        }
        return count;
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int x = 0; x <= n; ++x) {
            ans[x] = popCount(x);
        }
        return ans;
    }
}
