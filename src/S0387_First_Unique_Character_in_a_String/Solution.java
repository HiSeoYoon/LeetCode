package S0387_First_Unique_Character_in_a_String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String input = "loveleetcode";
        int output = firstUniqChar(input);
        System.out.println(output);
    }

    public static int firstUniqChar(String s){
        LinkedHashMap<Character, Integer> cntChar = new LinkedHashMap<>();

        char[] strArr = s.toCharArray();

        for(int i = 0; i<strArr.length; i++){
            if(cntChar.containsKey(strArr[i])){
                cntChar.put(strArr[i], -1);
            }
            else{
                cntChar.put(strArr[i], i);
            }
        }
        for(Map.Entry<Character, Integer> entry : cntChar.entrySet()){
            if(entry.getValue() != -1){
                return entry.getValue();
            }
        }
        return -1;
    }
}
