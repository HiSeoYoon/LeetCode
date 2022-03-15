package S2099_Find_Subsequence_of_Length_K_With_the_Largest_Sum;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] input = {-1, -2, 3, 4};
        int[] output = maxSubsequence(input, 3);
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int[] maxSub = new int[k];
        int[] sortedInput = nums;

        Arrays.sort(sortedInput);
        int[] findIndex = new int[k];

        for (int i = 0; i < k; i++) {
            int getIndex = Arrays.binarySearch(nums, sortedInput[nums.length - 1 - i]);

            findIndex[i] = getIndex;
        }

        Arrays.sort(findIndex);
        for (int j = 0; j < k; j++) {
            maxSub[j] = nums[findIndex[j]];
            System.out.println(maxSub[j]);
        }

        return maxSub;
    }
}
