package com.example.demo.netconnection.tcp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

/**
 * Created by billy on 18-1-2.
 */
public class NioTcpClient {

    private static final Logger logger = Logger.getLogger(NioTcpClient.class.getName());
    private InetSocketAddress inetSocketAddress;

    public NioTcpClient(String hostname, int port) {
        inetSocketAddress = new InetSocketAddress(hostname, port);
    }

    public void send(String messgae) {
        try {
            SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
            socketChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            socketChannel.write(ByteBuffer.wrap(messgae.getBytes()));
            while (true) {
                byteBuffer.clear();
                int readBytes = socketChannel.read(byteBuffer);
                if (readBytes > 0) {
                    byteBuffer.flip();
                    logger.info("get message: " + new String(byteBuffer.array(), 0, readBytes));
                    socketChannel.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NioTcpClient("localhost", 8080).send("this is testing message");
    }
}
