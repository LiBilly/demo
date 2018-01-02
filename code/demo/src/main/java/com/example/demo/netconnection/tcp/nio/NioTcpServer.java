package com.example.demo.netconnection.tcp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by billy on 18-1-2.
 */
public class NioTcpServer extends Thread {

    private static final Logger logger = Logger.getLogger(NioTcpServer.class.getName());
    private InetSocketAddress inetSocketAddress;
    private ServerHandler handler = new NioTcpServerHandler();

    public NioTcpServer(String hostname, int port) {
        inetSocketAddress = new InetSocketAddress(hostname, port);
    }

    @Override
    public void run() {
        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(inetSocketAddress);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            logger.info("Server: socket server started.");
            while(true) {
                int nKeys = selector.select();
                if(nKeys > 0) {
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    Iterator<SelectionKey> it = selectedKeys.iterator();
                    while(it.hasNext()) {
                        SelectionKey key = it.next();
                        if(key.isAcceptable()) {
                            logger.info("Server: SelectionKey is acceptable.");
                            handler.handleAccept(key);
                        } else if(key.isReadable()) {
                            logger.info("Server: SelectionKey is readable.");
                            handler.handleRead(key);
                        } else if(key.isWritable()) {
                            logger.info("Server: SelectionKey is writable.");
                            handler.handleWrite(key);
                        }
                        it.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != serverSocketChannel && serverSocketChannel.isOpen()) {
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        NioTcpServer server = new NioTcpServer("localhost", 8080);
        server.start();
    }
}
