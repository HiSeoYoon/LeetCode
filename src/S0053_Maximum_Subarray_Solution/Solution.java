package S0053_Maximum_Subarray_Solution;

public class Solution {
    public static void main(String[] args) {
        int[] input = {5, 4, -1, 7, 8};
        int output = maxSubArray(input);
        System.out.println(output);
    }

    public static int maxSubArray(int[] nums) {
        int maxSubarray = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currentSubarray = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubarray += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }
        }
        return maxSubarray;
    }
}
