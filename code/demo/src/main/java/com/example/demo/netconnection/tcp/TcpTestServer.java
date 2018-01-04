package com.example.demo.netconnection.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by billy on 18-1-2.
 */
public class TcpTestServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("tcp server is up, ready to receive message.");
            boolean f = true;
            while(f) {
                Socket client = serverSocket.accept();
                System.out.println("connection established.");
                TcpTestServerHandler handler = new TcpTestServerHandler(client);
                handler.start();
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
