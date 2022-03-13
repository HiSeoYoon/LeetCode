package S0605_Can_Place_Flowers;

public class Solution {
    public static void main(String[] args) {
        int[] input = {1,0,0,0,1};
        boolean output = canPlaceFlowers(input, 1);
        System.out.println(output);

    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n){
        //2나누기 했을 경우 몫이 1 이상이고 나머지가 1이어야 1자리 가능함

        int canPlace = 0;
        int countPlace = 0;
        for (int j : flowerbed) {
            //1나오기 전까지의 0의 값을 합치거나 마지막 자리일때 계산 필요
            if (Integer.compare(j, 0) == 0) {
                countPlace++;
            } else {
                canPlace += chkPlace(countPlace);
                countPlace = 0;
            }

            if(j == flowerbed.length -1){
                canPlace += chkPlace(countPlace);
            }
        }

        return canPlace >= n;
    }

    public static int chkPlace(int emptyCount){
        int chkPlace = 0;
        if (emptyCount > 2) {
            int digit = emptyCount / 2;
            int digits = emptyCount % 2;
            chkPlace += (digit + digits - 1);
        }
        return chkPlace;
    }
}
