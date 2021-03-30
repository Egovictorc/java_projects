package com.victor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyFile {
    public static void main(String[] args) {
        File file = new File("readme.txt");
        Scanner sc;
        try {
            boolean success = file.createNewFile();
            if(success) {
                System.out.println(String.format("%s created ", file.getName()));
            } else {
                System.out.println(String.format("%s already exists", file.getName()));
            }
            sc = new Scanner(file);
            while(sc.hasNextLine()) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
