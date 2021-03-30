package phone;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Contact> contacts;
    private static Scanner scanner;

    public static void main(String[] args) {

        contacts = new ArrayList<>();
        System.out.println("Welcome to my humble world of program");
        showInitialOptions();
    }

    private static void showInitialOptions() {
        System.out.println("Please select one: " +
                "\n\t1. Message Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");

        scanner  = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice) {
            
        }
    }
}
