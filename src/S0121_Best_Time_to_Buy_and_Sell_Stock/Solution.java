package S0121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        int output = maxProfit(input);
        System.out.println(output);
    }

    public static int maxProfit(int[] prices) {
        int minVal = -1;
        int maxVal = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1] && (prices[i] < minVal || minVal == -1)) {
                minVal = prices[i];
                maxVal = prices[i + 1];
            }

            if (maxVal < prices[i + 1]) {
                maxVal = prices[i + 1];
            }
        }

        if (maxVal != 0 && minVal != -1 && maxVal - minVal > 0) {
            return maxVal - minVal;
        }

        return 0;
    }
}
