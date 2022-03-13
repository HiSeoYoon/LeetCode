package Common;

public class ArraysCreator {
    public static void main(String[] args) {
        ArraysCreator.replace("[[5,10],[2,5],[4,7],[3,9]]");
        //("[[4,3],[1,4],[4,8],[1,7],[6,4],[4,2],[7,4],[4,0],[0,9],[5,4]]");
    }

    public static void replace(String str) {
        str = str.replace("[", "{");
        str = str.replace("]", "}");

        System.out.println(str);
    }
}