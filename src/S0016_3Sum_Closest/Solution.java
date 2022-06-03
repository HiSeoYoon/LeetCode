package S0016_3Sum_Closest;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] input = {-6, -3, -1, 2, 3, 5};//, 2, 1, -4};
        int output = threeSumClosest_1(input, 0);
        System.out.println(output);
    }

    public static int threeSumClosest_1(int[] nums, int target) {
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        int low = 0;
        int high = 0;

        for (int i = 0; i < nums.length; i++) {
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                diff = (Math.abs(target - sum) < Math.abs(diff)) ? target - sum : diff;
                if (sum < target) {
                    low++;
                } else if (sum > target) {
                    high--;
                } else {
                    return target;
                }
            }
        }

        System.out.println("diff : " + (target - diff));

        return target - diff;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < sz && diff != 0; ++i) {
            int lo = i + 1;
            int hi = sz - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return target - diff;
    }
}
