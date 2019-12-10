package com.dalaoyang.test;

import java.util.ArrayList;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args) {
        Collection myCollection = new ArrayList();
        myCollection.add("test1");
        myCollection.add("test2");
        myCollection.forEach((a) -> {
            System.out.println(a);
        });
    }
}
