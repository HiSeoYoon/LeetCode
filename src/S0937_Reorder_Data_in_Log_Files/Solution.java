package S0937_Reorder_Data_in_Log_Files;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        String[] input = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        reorderLogFiles(input);
    }

    public static String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split(" ", 2);
                String[] split2 = o2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if (!isDigit1 && !isDigit2) {
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) return cmp;
                    return split1[0].compareTo(split2[0]);
                }
                if (!isDigit1 && !isDigit2) return -1;
                else if (isDigit1 && !isDigit2) return 1;
                else return 0;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}
