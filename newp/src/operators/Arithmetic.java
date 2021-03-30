package operators;

import java.util.Arrays;

public class Arithmetic {


    public static int max(int x, int y) {
        if(x > y) {
            return x;
        } else {
            return y;
        }
    }
    public static void max2(int x, int y) {
        if(x > y) {
            System.out.println(x);
        } else {
            System.out.println(y);
        }
    }


    public static void main(String[] args) {

        System.out.println(max(3,4));
        max2(5,7);

       /* String[] cars = {"BMW", "volvo", "ford", "matda"};
        int[] scores = {70, 50, 80, 90};
        int[][] myNums = {{1,2,3}, {2,3} };

        for (int i = 0; i < myNums.length; i++) {
            for(int j = 0; j < myNums[i].length; j++) {
                System.out.print(myNums[i][j]+ ", ");
            }
            System.out.println("");
        }*/
    }

}
