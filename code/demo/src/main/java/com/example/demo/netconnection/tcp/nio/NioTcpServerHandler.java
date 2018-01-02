package com.example.demo.netconnection.tcp.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

/**
 * Created by billy on 18-1-2.
 */
public class NioTcpServerHandler implements ServerHandler {

    private static final Logger logger = Logger.getLogger(NioTcpServerHandler.class.getName());

    @Override
    public void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        logger.info("Server: accept client socket " + socketChannel);
        socketChannel.configureBlocking(false);
        socketChannel.register(key.selector(), SelectionKey.OP_READ);
    }

    @Override
    public void handleRead(SelectionKey key) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        SocketChannel socketChannel = (SocketChannel)key.channel();
        while(true) {
            int readBytes = socketChannel.read(byteBuffer);
            if(readBytes>0) {
                logger.info("Server: readBytes = " + readBytes);
                logger.info("Server: data = " + new String(byteBuffer.array(), 0, readBytes));
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                break;
            }
        }

        socketChannel.close();
    }

    @Override
    public void handleWrite(SelectionKey key) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
        byteBuffer.flip();
        SocketChannel socketChannel = (SocketChannel)key.channel();
        socketChannel.write(byteBuffer);
        if(byteBuffer.hasRemaining()) {
            key.interestOps(SelectionKey.OP_READ);
        }
        byteBuffer.compact();
    }
}
