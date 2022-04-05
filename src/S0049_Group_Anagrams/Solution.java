package S0049_Group_Anagrams;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupStr = new ArrayList<>();
        List<String> sameSpell = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String curStrs = strs[i];
            if (curStrs == null) {
                continue;
            }
            sameSpell.add(curStrs);
            System.out.println("Check Same! : " + curStrs);
            for (int j = i + 1; j < strs.length; j++) {
                String compareStr = strs[j];
                if (compareStr == null) {
                    continue;
                }
                String[] findStr = curStrs.split("");
                int findLen = 0;
                for (String s : findStr) {
                    if (0 <= compareStr.indexOf(s)) {
                        sameSpell.add(compareStr);
                        findLen++;
                        if (findLen == findStr.length) {
                            sameSpell.add(compareStr);
                            System.out.println("Same : " + compareStr);
                            strs[j] = null;
                        }
                    } else {
                        break;
                    }
                }
            }

            groupStr.add(sameSpell);
        }
        return groupStr;
    }
}
