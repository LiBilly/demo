package com.example.demo.netconnection.udp.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by billy on 18-1-10.
 */
public class UdpTestClient {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(8081)) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            boolean isContinue = true;
            while (isContinue) {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("message from " + packet.getSocketAddress() + ": " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
