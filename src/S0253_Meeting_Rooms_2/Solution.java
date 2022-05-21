package S0253_Meeting_Rooms_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] input = {{0, 30}, {5, 10}, {15, 20}};
        int output = minMeetingRooms(input);
        System.out.println(output);
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1 - o2;
                            }
                        }
                );

        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    @Override
                    public int compare(final int[] o1, final int[] o2) {
                        return o1[0] - o2[0];
                    }
                }
        );

        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
}
