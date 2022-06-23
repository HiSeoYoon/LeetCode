package S0888_Fair_Candy_Swap;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] inputA = {1, 1};
        int[] inputB = {2, 2};
        int[] output = fairCandySwap(inputA, inputB);
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;  // sum of A, B respectively
        for (int x : A) sa += x;
        for (int x : B) sb += x;
        int delta = (sb - sa) / 2;
        // If Alice gives x, she expects to receive x + delta

        Set<Integer> setB = new HashSet();
        for (int x : B) setB.add(x);

        for (int x : A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};

        throw null;
    }
}
