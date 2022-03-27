package S0070_Climbing_Stairs;

public class Solution {
    public static void main(String[] args) {
        int output = climbStairs(5);
    }

    public static int climbStairs(int n) {
        int firstStep = 1;
        int secondStep = 2;
        int totalStep = 0;
        int prevStep = 0;
        int currStep = 0;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return firstStep;
        } else if (n == 2) {
            return secondStep;
        }
        for (int i = 2; i < n; i++) {
            if (i == 2) {
                totalStep = firstStep + secondStep;
                prevStep = secondStep;
            } else {
                currStep = totalStep;
                totalStep += prevStep;
                prevStep = currStep;
            }
        }
        return totalStep;
    }

    public static int leetCodeSol(int n) {
        return climb_Stairs(0, n);
    }

    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
}
