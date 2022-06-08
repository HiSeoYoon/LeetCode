package S1631_Path_With_Minimum_Effort;

public class Solution {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        minimumEffortPath(input);
    }

    public static int minimumEffortPath(int[][] heights) {
        return backtrack(0, 0, heights, heights.length, heights[0].length, 0);
    }

    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int maxSoFar = Integer.MAX_VALUE;

    public static int backtrack(int x, int y, int[][] heights, int row, int col, int maxDifference) {
        if (x == row - 1 && y == col - 1) {
            maxSoFar = Math.min(maxSoFar, maxDifference);
            return maxDifference;
        }
        int currentHeight = heights[x][y];
        heights[x][y] = 0;
        int minEffort = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int adjacentX = x + directions[i][0];
            int adjacentY = y + directions[i][1];
            if (isValidCell(adjacentX, adjacentY, row, col) && heights[adjacentX][adjacentY] != 0) {
                int currentDifference = Math.abs(heights[adjacentX][adjacentY] - currentHeight);
                int maxCurrentDifference = Math.max(maxDifference, currentDifference);
                if (maxCurrentDifference < maxSoFar) {
                    int result = backtrack(adjacentX, adjacentY, heights, row, col, maxCurrentDifference);
                    minEffort = Math.min(minEffort, result);
                }
            }
        }
        heights[x][y] = currentHeight;
        return minEffort;
    }

    public static boolean isValidCell(int x, int y, int row, int col) {
        return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1;
    }
}
