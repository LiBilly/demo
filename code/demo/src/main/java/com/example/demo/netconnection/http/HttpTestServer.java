package com.example.demo.netconnection.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * Created by billy on 18-1-4.
 */
public class HttpTestServer {

    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 50);
            httpServer.createContext("/", new HttpTestHandler());
            httpServer.createContext("/sayHi", new SayHiHttpHandler());
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class HttpTestHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println(httpExchange.getRequestMethod());
            String responseBody = "this is http test server";
            httpExchange.sendResponseHeaders(200, responseBody.length());
            OutputStream out = httpExchange.getResponseBody();
            out.write(responseBody.getBytes());
            out.close();
        }
    }

    static class SayHiHttpHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println(httpExchange.getRequestMethod());
            String responseBody = "Hi";
            httpExchange.sendResponseHeaders(200, responseBody.length());
            OutputStream out = httpExchange.getResponseBody();
            out.write(responseBody.getBytes());
            out.close();
        }
    }

}
