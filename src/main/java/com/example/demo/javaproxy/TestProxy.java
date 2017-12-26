package com.example.demo.javaproxy;

/**
 * Created by billy on 17-12-26.
 */
public class TestProxy {

    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();
    }

}
