package S0200_Number_of_Islands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }

    public static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static int numIslands_1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }

    public static int numIslands_2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }


/*
        //전체 리스트 그리고 맨 앞 뒤 값을 알아야 뒤에서도 풀 수 있음
    public static int rowNum;// = grid.length; //행 최대값
    public static int colNum;// = grid[0].length; //열 최대값
    // 1   2   {1,1},{2,2}
    //public static List<Map<Integer, Integer>> landchkList;// = new ArrayList<>();
    //public static Map<Integer, List<Integer>> landchkList;// = new HashMap<>()
    public static List<List<ArrayList<Integer>>> landchkList;

    public static int numIslands(char[][] grid) {
        //상 하 좌 우 인데 거기서 맨 끝인 경우 무조건 조건을 충족함
        //1이 있는 경우 상하좌우를 체크하면서 진행하도록 함
        //1이 연속되는 경우는 모두 충족하는 조건인지를 확인
        //1이 지속되는 경우도 있을테니 큰 아일랜드가 지속됨을 확인해야함

        //1이 뒤에 오는 경우에 앞의 값이 어떻게 되었는지 확인이 필요하므로 1인값은 hashset등에 넣어서 확인하도록
        rowNum = grid.length; //행 최대값
        colNum = grid[0].length; //열 최대값

        landchkList = new ArrayList<>();

        //List<Map<Integer, Integer>> landList = new ArrayList<>();


        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                //ArrayList<Integer> curVal = new ArrayList<>();
                if (i != 0) {
                    //i값 체크 안함
                }
                if (j == 0) {
                    //j값 체크 안함
                }
                //if (grid[i][j] == '1') {
                //    curVal.put(i,j);
                //    landchkList.add(curVal);
                //}
            }
        }
        //상하좌우가 끝나는 점인지 확인하고 개수가 for문 돌면서 여러개가 있을수 있는데 연결되어있음을 어떻게 알 수 있을지?
        //for문 돌면서 하나로 저장되는 것이 있는지를 확인하도록 해야한다.
        //앞에것과 연결하면서 우선 가로방향으로 체크먼저! 그리고 그런 다음은 아래방향인데
        //값이 1이든 0이든 확인하되 1이면 기존에 있던 것에 연결 또는 새로 생성하고 없으면 List에 추가하는방향으로
        //완성되는것도 리스트에 넣어야지!!!!!!!!!
        //이게 끝난건지는 어떻게 확인?
        return landchkList.size();
    }

    public static int checkIsland(int rowVal, int colVal) {
        //row앞에 값과 col앞 뒤 값 체크 후 기존에 있던 값에 넣어주던지
        //아니면 새로 리스트에 추가

        //0,0이거나 앞에 값들 모두 비어있으면 새로시작
        //왼쪽체크, 오른쪽체크해서 앞에 값이 있으면 List에 추가 필요

        ArrayList<Integer> curVal = new ArrayList<>();
        List<ArrayList<Integer>> chkList = new ArrayList<>();

        if (colVal == 0) {
            if (rowVal == 0) {
                curVal.add(rowVal, colVal);
                chkList.add(curVal);
                landchkList.add(chkList);
            }
        } else {

        }

    }*/
}
