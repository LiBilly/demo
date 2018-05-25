package com.example;

import java.util.function.Function;

public class Testing {

    public static void main(String[] args) {
        String name = "";
        String name1 = "12345";
        System.out.println(
                (
                        (Function<String, String>)
                        name2 -> {
                            String test = name1 + "+" + name2;
                            return test;
                        }
                ).andThen(
                        name3 -> name3.toString() + '+'
                ).apply(name)
        );
//        name1 = name1 + "test";

        Function f = (
                (Function) arg1 -> arg1.toString() + " + 1"
        ).compose(arg2 -> arg2.toString() + " + 2");
        System.out.println(f.apply('0'));
    }
}
