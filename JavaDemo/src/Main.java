
public class Main {
    public static void main(String[] args) {
        String name = "Emeka Okafor";
        int count = 0;
        do {
            System.out.println(name.charAt(count));
            count++;
        } while( count < name.length() );

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
