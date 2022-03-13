package S0696_Count_Binary_Substrings;

import java.util.ArrayList;
import java.util.Objects;

public class Solution {

    public static void main(String[] args) {
        String input = "00110011";
        int output = countBinarySubstrings(input);
        System.out.println(output);
    }

    public static int countBinarySubstrings(String s){
        int retVal = 0;
        ArrayList<Integer> cntList = new ArrayList<>();

        int trueCnt = 0;
        int falseCnt = 0;
        for(int i = 0; i<s.length(); i++){
            //int curVal = s.charAt(i) == '1'? 1 : 0;
            char curChar = s.charAt(i);
            if(0 == Character.compare(curChar, '1')){
                trueCnt++;
            }
            else{
                falseCnt++;
            }
            if(i == s.length() - 1 || 0!=Character.compare(curChar, s.charAt(i + 1))){
                if(Character.compare(curChar,'1') == 0){
                    cntList.add(trueCnt);
                    System.out.println("Add True List Val :" + trueCnt);
                    trueCnt = 0;
                }
                else{
                    cntList.add(falseCnt);
                    System.out.println("Add False List Val :" + falseCnt);
                    falseCnt = 0;
                }
            }
        }

        for(int j = 0; j<cntList.size() - 1; j++){
            if(Objects.equals(cntList.get(j), cntList.get(j + 1))){
                retVal += cntList.get(j);
            }
            else if(cntList.get(j)>cntList.get(j+1)){
                retVal += cntList.get(j+1);
            }
            else{
                retVal += cntList.get(j);
            }
        }

        return retVal;
    }
}
