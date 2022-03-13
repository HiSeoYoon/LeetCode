package S0496_Next_Greater_Element_1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] inputNums1 = {4,1,2};//{2,4};//{4,1,2};
        int[] inputNums2 = {1,3,4,2};//{1,2,3,4};//{1,3,4,2};
        int[] output = nextGreaterElement(inputNums1, inputNums2);
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        int[] greaterElement = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){
            int curNum = nums1[i];
            int findIdx = Arrays.binarySearch(nums2, curNum);
            int inputNum = -1;
            if(findIdx + 1 != nums2.length && findIdx > -1){
                if(curNum < nums2[findIdx + 1]){
                    inputNum = nums2[findIdx + 1];
                }
            }
            greaterElement[i] = inputNum;

            System.out.println(i + "번째 : " + inputNum);
        }
        return greaterElement;
    }
}
