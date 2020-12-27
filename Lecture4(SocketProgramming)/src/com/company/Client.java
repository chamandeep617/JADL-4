package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",4001);
        System.out.println("connected to the server");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        Scanner sc = new Scanner(System.in);
        String msg;
        do{
            System.out.println("Enter the message you want to send to the server : ");
            msg = sc.nextLine();

            out.println(msg);
            String reponse = in.readLine();

            System.out.println(reponse);
        }while(!msg.equals("exit"));
    }
}
