package S0062_Unique_Paths;

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
}
