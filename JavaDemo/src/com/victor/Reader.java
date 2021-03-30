package com.victor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) throws IOException {
        File file = new File("readme.txt");
        char[] arrays = new char[100];


        try {
            FileReader rd = new FileReader(file);
            int ch = rd.read();
            while(ch != -1) {
                System.out.print((char)ch);
                ch = rd.read();
            }

          /*  Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }*/
            //FileReader rd = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
