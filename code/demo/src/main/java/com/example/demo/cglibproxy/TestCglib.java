package com.example.demo.cglibproxy;

/**
 * Created by billy on 17-12-27.
 */
public class TestCglib {

    public static void main(String[] args) {
        BookFacadeCglibProxy cglib = new BookFacadeCglibProxy();
        BookFacadeImpl1 bookCglib = (BookFacadeImpl1) cglib.getInstance(new BookFacadeImpl1());
        BookFacadeImpl2 bookCglib2 = (BookFacadeImpl2) cglib.getInstance(new BookFacadeImpl2());
        bookCglib.addBook();
        bookCglib2.addBook2();
    }
}
