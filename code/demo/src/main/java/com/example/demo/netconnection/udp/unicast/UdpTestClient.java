package com.example.demo.netconnection.udp.unicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by billy on 18-1-2.
 */
public class UdpTestClient {

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress clientAddress = InetAddress.getByName("localhost");
            String responseMessgae = "this is a testing message2.";
            byte[] responseData = responseMessgae.getBytes();
            DatagramPacket responsePacket =
                    new DatagramPacket(responseData, responseData.length, clientAddress, 8080);
            datagramSocket.send(responsePacket);

            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
