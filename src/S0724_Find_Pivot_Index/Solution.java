package S0724_Find_Pivot_Index;

public class Solution {
    public static void main(String[] args) {
        int[] input = {1, 7, 3, 6, 5, 6};
        int output = pivotIndex(input);
        System.out.println(output);
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
