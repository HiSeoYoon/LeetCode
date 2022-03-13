package S0136_Single_Number;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] input = {4,1,2,1,2};
        int ouput = singleNumber(input);
        System.out.print(ouput);
    }

    public static int singleNumber(int[] nums){
        if(nums.length == 1)
        {
            return nums[0];
        }

        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(numsMap.containsKey(nums[i])){
                numsMap.put(nums[i], 2);
            }
            else{
                numsMap.put(nums[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : numsMap.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }
}
