package S1710_Maximum_Units_on_a_Truck;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {

        int[][] input = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};//{{1,3},{2,2},{3,1}};
        int ouput = maximumUnits(input, 10);
        System.out.println(ouput);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxmumSum = 0;
        Arrays.sort(boxTypes, Comparator.comparing(o1 -> -o1[1]));

        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize < 1) {
                break;
            }
            int boxCount = boxTypes[i][0];
            System.out.println(i + "번째 : " + boxCount);
            if (truckSize >= boxCount) {
                maxmumSum += boxCount * boxTypes[i][1];
            } else {
                maxmumSum += boxTypes[i][1] * truckSize;
            }
            truckSize -= boxCount;
        }
        return maxmumSum;
    }
}
