package com.example.demo.netconnection.tcp.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * Created by billy on 18-1-2.
 */
public interface ServerHandler {

    void handleAccept(SelectionKey key) throws IOException;

    void handleRead(SelectionKey key) throws IOException;

    void handleWrite(SelectionKey key) throws IOException;
}
