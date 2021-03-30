package com.victor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void main(String[] args) {
        //File file = new File("writeme.txt");
        String str = "File handling in Java using filewriter and filereader";
        try{
          //  boolean success = file.createNewFile();

            FileWriter fw = new FileWriter("writeme.txt");
                fw.write(3);
            /*for(int i = 0; i < str.length(); i++) {
                int data = str.charAt(i);
                fw.write(data);
            }
            */fw.write(str.toCharArray());

        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("finished writing data successfully");
    }
}
