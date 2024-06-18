package com.example.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author:King
 * Create:2024/6/12 11:09
 */
public class IODemo {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("C:\\Users\\King\\Desktop\\a.txt");
            int len = 0 ;
            byte[] bys = new byte[4];
            while ((len = inputStream.read(bys)) != -1) {
                System.out.println(new String(bys,0,len));
            }

            FileReader fileReader = new FileReader("C:\\Users\\King\\Desktop\\a.txt");
            System.out.println(fileReader.getEncoding());
            new BufferedReader(fileReader);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
