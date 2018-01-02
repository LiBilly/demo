package com.example.demo.netconnection.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by billy on 18-1-2.
 */
public class UdpServerHandler implements Runnable {

    private DatagramSocket datagramSocket;
    private DatagramPacket packet;
    private byte[] data;

    public UdpServerHandler(DatagramSocket datagramSocket, DatagramPacket packet, byte[] data) {
        this.datagramSocket = datagramSocket;
        this.packet = packet;
        this.data = data;
    }

    @Override
    public void run() {
        String message = new String(data, 0, packet.getLength());
        System.out.println("received message: " + message);

        InetAddress clientAddress = packet.getAddress();
        int clientPort = packet.getPort();
        String responseMessgae = "received your message as: " + message;
        byte[] responseData = responseMessgae.getBytes();
        DatagramPacket responsePacket =
                new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
        try {
            datagramSocket.send(responsePacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
