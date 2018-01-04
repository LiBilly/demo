package com.example.demo.netconnection.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by billy on 18-1-2.
 */
public class TcpTestServerHandler extends Thread {

    private Socket client = null;

    public TcpTestServerHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            PrintStream out = new PrintStream(client.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true) {
                String str = bufferedReader.readLine();
                if (null == str) {
                    break;
                }
                System.out.println("receive message: " + str);
                out.println("message your sent is: " + str);
            }
            bufferedReader.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
