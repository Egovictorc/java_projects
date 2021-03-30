package main;

public class TestException {
    public static void main(String[] args) {
        int x = 5;

        try {
            int res = x / 0;

        } catch(ArrayIndexOutOfBoundsException | ArithmeticException ae) {
            // ae.printStackTrace();
            System.out.println("error occured here");
        }
    }
}
