package S0387_First_Unique_Character_in_a_String;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String input = "loveleetcode";
        int output = firstUniqChar(input);
        System.out.println(output);
    }

    public static int firstUniqChar(String s){
        LinkedHashMap<Character, Integer> cntChar = new LinkedHashMap<>();
        for(int i = 0; i<s.length(); i++){
            char curChar = s.charAt(i);
            if(cntChar.containsKey(curChar)){
                cntChar.put(curChar, -1);
            }
            else{
                cntChar.put(curChar, i);
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
