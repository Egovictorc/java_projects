
public class Main {
    public static void main(String[] args) {
        int i = 41;

        System.out.println("hello world");
        while( i > 22) {
            //System.out.println(i % 3);
            if ( (i % 3) == 0) {
                System.out.println(i);
            }
            i -= 1;
        }
    } 
}
