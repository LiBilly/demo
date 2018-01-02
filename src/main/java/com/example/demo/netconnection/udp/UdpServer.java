package com.example.demo.netconnection.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by billy on 18-1-2.
 */
public class UdpServer {

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8080);
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            System.out.println("udp server is up, ready to receive message.");

            boolean flag = true;
            while (flag) {
                datagramSocket.receive(packet);
                new Thread(new UdpServerHandler(datagramSocket, packet, data)).start();
            }

            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
