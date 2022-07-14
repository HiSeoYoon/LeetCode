package S0169_Majority_Element;

public class Solution {
    public static void main(String[] args) {
        int[] input = {3, 2, 3};
        System.out.println(majorityElement(input));
    }

    public static int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;
    }
}
