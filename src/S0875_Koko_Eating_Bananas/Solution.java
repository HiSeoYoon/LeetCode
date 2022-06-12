package S0875_Koko_Eating_Bananas;

public class Solution {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int output = minEatingSpeed(piles, 8);
        System.out.println(output);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int speed = 1;

        while (true) {
            int hourSpent = 0;

            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / speed);
                if (hourSpent > h) {
                    break;
                }
            }

            if (hourSpent <= h) {
                return speed;
            } else {
                speed += 1;
            }
        }
    }
}
