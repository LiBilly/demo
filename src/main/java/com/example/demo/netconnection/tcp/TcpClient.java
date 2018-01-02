package com.example.demo.netconnection.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by billy on 18-1-2.
 */
public class TcpClient {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8080);
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println("this is testing message from tcp client.");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String str = bufferedReader.readLine();
                if (null == str) {
                    break;
                }
                System.out.println("receive message: " + str);
            }
            bufferedReader.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
