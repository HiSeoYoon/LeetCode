package S0643_Maximum_Average_Subarray_1;

public class Solution {
    public static void main(String[] args) {
        int[] input = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(input, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        double res = sum[k - 1] * 1.0 / k;

        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }
}
