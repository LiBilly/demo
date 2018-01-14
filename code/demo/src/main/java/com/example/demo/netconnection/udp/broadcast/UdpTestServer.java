package com.example.demo.netconnection.udp.broadcast;

import java.io.IOException;
import java.net.*;

/**
 * Created by billy on 18-1-10.
 */
public class UdpTestServer {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setBroadcast(true);

            String message = "this is broadcast message";

            // 255.255.255.255
            SocketAddress address = new InetSocketAddress("255.255.255.255", 8081);
            DatagramPacket packet = new DatagramPacket(message.getBytes(), 0, message.getBytes().length, address);
            boolean isContinue = true;
            int count = 0;
            while (isContinue) {
                socket.send(packet);
                System.out.println("send message at: " + ++count);
                Thread.sleep(5000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
