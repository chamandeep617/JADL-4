package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(4001);
        System.out.println("waiting for the client connection");

        while(true){
            Socket clientSocket = socket.accept();
            System.out.println("Client connected");
            Messaging obj = new Messaging(clientSocket);
            obj.start();
        }
    }
}
