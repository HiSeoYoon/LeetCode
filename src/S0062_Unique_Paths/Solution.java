package S0062_Unique_Paths;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        int totalFactorial = factorialVal(m - 1 + n - 1);
        int mFacVal = factorialVal(m - 1);
        int nFacVal = factorialVal(n - 1);

        return totalFactorial / (mFacVal * nFacVal);
    }

    public static int factorialVal(int val) {
        if (val <= 2) {
            return val;
        }
        return val * factorialVal(val - 1);
    }

    public static int uniquePaths2(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths2(m - 1, n) + uniquePaths2(m, n - 1);
    }

    public static int uniquePaths3(int m, int n) {
        int[][] d = new int[m][n];

        for (int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for (int col = 1; col < m; ++col) {
            for (int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];
    }
}
