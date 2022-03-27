package S0746_Min_Cost_Climbing_Stairs;

public class Solution {
    public static void main(String[] args) {
        int[] input = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}; //{10, 15, 20};
        int output = minCostClimbingStairs(input);
        System.out.println(output);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int zeroStart = getStairs(cost, 0);
        int oneStart = getStairs(cost, 1);

        System.out.println("zero : " + zeroStart);
        System.out.println("one : " + oneStart);

        return Math.min(zeroStart, oneStart);

    }

    public static int getStairs(int[] cost, int start) {
        int stairs = cost[start];
        for (int i = start; i < cost.length; i++) {
            if (i < cost.length - 2) {
                if (cost[i + 1] < cost[i + 2]) {
                    stairs += cost[i + 1];
                } else {
                    stairs += cost[i + 2];
                    i++;
                }
            } else {
                break;
            }
        }
        return stairs;
    }

    public static int leetCodeSol(int[] cost) {
        int minimumCost[] = new int[cost.length + 1];

        for (int i = 2; i < minimumCost.length; i++) {
            int takeOneStep = minimumCost[i - 1] + cost[i - 1];
            int takeTwoStep = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(takeOneStep, takeTwoStep);
        }
        return minimumCost[minimumCost.length - 1];
    }
}
