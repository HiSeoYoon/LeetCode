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

    public static int kadansAlgorithm(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        return maxSubarray;
    }

    private static int[] numsArray;

    public static int divideConquer(int[] nums) {
        numsArray = nums;
        return findBestSubarray(0, numsArray.length - 1);
    }

    private static int findBestSubarray(int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }

        int mid = Math.floorDiv(left + right, 2);
        int curr = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;

        for (int i = mid - 1; i >= left; i--) {
            curr += numsArray[i];
            bestLeftSum = Math.max(bestLeftSum, curr);
        }

        curr = 0;
        for (int i = mid + 1; i <= right; i++) {
            curr += numsArray[i];
            bestRightSum = Math.max(bestRightSum, curr);
        }
        int bestCombinedSum = numsArray[mid] + bestLeftSum + bestRightSum;

        int leftHalf = findBestSubarray(left, mid - 1);
        int rightHalf = findBestSubarray(mid + 1, right);

        return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
    }


}
