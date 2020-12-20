package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) throws IOException {
        FileReader in = null;
        FileWriter out = null;
        int c;
        try{
            in = new FileReader("/home/chamandeep/Desktop/input.txt");
            out = new FileWriter("/home/chamandeep/Desktop/output.txt");
            while((c = in.read()) != -1){
                out.write(c);
            }
            System.out.println("file written");
        }catch(Exception e){
            System.out.println("Error !!");
        }finally {
            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
        }
    }
}
