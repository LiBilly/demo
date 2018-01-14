package com.example.demo.snap;

import java.util.*;

/**
 * Created by billy on 18-1-5.
 */
public class MainClass {

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, 1);
        linkedHashMap.put(3, 3);
        linkedHashMap.put(2, 2);
        linkedHashMap.put(4, 4);
        linkedHashMap.put(1, 11);

        Set keys = linkedHashMap.keySet();
        System.out.println(linkedHashMap.get(1));

    }

}
