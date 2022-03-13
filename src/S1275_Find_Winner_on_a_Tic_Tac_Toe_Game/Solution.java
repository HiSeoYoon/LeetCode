package S1275_Find_Winner_on_a_Tic_Tac_Toe_Game;


import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int[][] input = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
        //{{0,0},{2,0},{1,1},{2,1},{2,2}};
        String output = tictactoe(input);
        System.out.print(output);
    }

    public static String tictactoe(int[][] moves) {
        int AsameThing = 0;
        int BsameThing = 0;
        int ACrossThing = 0;
        int BCrossThing = 0;
        boolean chkTurn = false;

        ArrayList<Integer> AleftVal = new ArrayList<>();
        ArrayList<Integer> ArightVal = new ArrayList<>();

        ArrayList<Integer> BleftVal = new ArrayList<>();
        ArrayList<Integer> BrightVal = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            int leftVal = moves[i][0];
            int rightVal = moves[i][1];
            System.out.println("Input : " + i + "번째" + ", " + leftVal + ", " + rightVal);

            if (chkTurn == false) {
                System.out.println("A Turn");
                AleftVal.add(leftVal);
                ArightVal.add(rightVal);
                chkTurn = true;

                if (leftVal == rightVal) {
                    System.out.println("Check Same value");
                    AsameThing++;
                }
                if (leftVal + rightVal == 2) {
                    ACrossThing++;
                }

                if (AleftVal.size() > 2) {
                    if (Collections.frequency(AleftVal, 0) > 2 ||
                            Collections.frequency(AleftVal, 1) > 2 ||
                            Collections.frequency(AleftVal, 2) > 2 ||
                            Collections.frequency(ArightVal, 0) > 2 ||
                            Collections.frequency(ArightVal, 1) > 2 ||
                            Collections.frequency(ArightVal, 2) > 2 ||
                            AsameThing > 2 || ACrossThing > 2) {
                        return "A";
                    }
                }
            } else {
                System.out.println("B Turn");
                BleftVal.add(leftVal);
                BrightVal.add(rightVal);
                chkTurn = false;

                if (leftVal == rightVal) {
                    System.out.println("Check Same value");
                    BsameThing++;
                }
                if (leftVal + rightVal == 2) {
                    BCrossThing++;
                }

                if (BleftVal.size() > 2) {
                    if (Collections.frequency(BleftVal, 0) > 2 ||
                            Collections.frequency(BleftVal, 1) > 2 ||
                            Collections.frequency(BleftVal, 2) > 2 ||
                            Collections.frequency(BrightVal, 0) > 2 ||
                            Collections.frequency(BrightVal, 1) > 2 ||
                            Collections.frequency(BrightVal, 2) > 2 ||
                            BsameThing > 2 || BCrossThing > 2) {
                        return "B";
                    }
                }
            }
        }
        //list
        return "Draw";
    }
}
