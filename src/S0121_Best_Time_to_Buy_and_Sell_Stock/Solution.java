package S0121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        int output = maxProfit3(input);
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

    public static int maxProfit2(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    public static int maxProfit3(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
