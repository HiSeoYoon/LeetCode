package S0787_Cheapest_Flight_Within_K_Stops;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] input = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int output = findCheapestPrice(4, input, 0, 3, 1);
        System.out.println(output);
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // Build the adjacency matrix
        int adjMatrix[][] = new int[n][n];
        for (int[] flight : flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        // Shortest distances array
        int[] distances = new int[n];

        // Shortest steps array
        int[] currentStops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        distances[src] = 0;
        currentStops[src] = 0;

        // The priority queue would contain (node, cost, stops)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {

            int[] info = minHeap.poll();
            int node = info[0], stops = info[2], cost = info[1];

            // If destination is reached, return the cost to get here
            if (node == dst) {
                return cost;
            }

            // If there are no more steps left, continue
            if (stops == K + 1) {
                continue;
            }

            // Examine and relax all neighboring edges if possible
            for (int nei = 0; nei < n; nei++) {
                if (adjMatrix[node][nei] > 0) {
                    int dU = cost, dV = distances[nei], wUV = adjMatrix[node][nei];

                    // Better cost?
                    if (dU + wUV < dV) {
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        distances[nei] = dU + wUV;
                    } else if (stops < currentStops[nei]) {
                        // Better steps?
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                    }
                    currentStops[nei] = stops;
                }
            }
        }

        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
}
