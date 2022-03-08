package S0056_Merge_Intervals;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[][] inputVal = {{1,3},{2,6},{8,10},{15,18}};
        int[][] outputVal = merge(inputVal);
    }

    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> retList = new ArrayList<>();

        int skip = 0;

        for(int i = 0; i < intervals.length - 1; i++)
        {
            if(skip > 0)
            {
                skip = 0;
                continue;
            }

            int[] val;
            int[] firVal = intervals[i];
            int[] secVal = intervals[i+1];

            int fir = firVal[0];
            int sec = secVal[1];

            if(firVal[1] > secVal[0])
            {
                skip = 1;
                if(firVal[1] <= secVal[1])
                {
                    val = new int[]{fir, sec};
                    retList.add(val);
                }
                else
                {
                    retList.add(firVal);
                }
            }
            else
            {
                retList.add(firVal);
            }
            if(i == intervals.length - 2)
            {
                retList.add(intervals[i+1]);
            }
        }

        int[][] retVal = new int[retList.size()][2];

        for(int j = 0; j < retList.size(); j++)
        {
            retVal[j] = retList.get(j);
            System.out.print("{" + retList.get(j)[0] +","+retList.get(j)[1]+"}");
        }

        return retVal;
    }
}
