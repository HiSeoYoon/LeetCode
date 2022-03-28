package S0075_Sort_Colors;

public class Solution {
    public static void main(String[] args) {
        int[] input = {2, 0, 2, 1, 1, 0};
        sortColors(input);
    }

    public static void sortColors(int[] nums) {
        int curVal = 0, curPlace = 0, blue = 0;

        int[] sortArray = new int[nums.length];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == j) {
                    nums[i] = nums[curPlace];
                    nums[curPlace] = j;
                    curPlace++;
                }
            }
        }
        for (int k = 0; k < nums.length; k++) {
            System.out.println(nums[k]);
        }
    }
}
