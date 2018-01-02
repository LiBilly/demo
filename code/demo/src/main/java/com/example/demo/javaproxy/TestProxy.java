package com.example.demo.javaproxy;

/**
 * Created by billy on 17-12-26.
 */
public class TestProxy {

    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        Object target = proxy.bind(new BookFacadeImpl());
        BookFacade bookProxy = (BookFacade) target;
        bookProxy.addBook();
    }

}
