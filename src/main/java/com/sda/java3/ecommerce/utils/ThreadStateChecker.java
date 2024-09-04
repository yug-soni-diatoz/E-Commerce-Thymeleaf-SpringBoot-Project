package com.sda.java3.ecommerce.utils;

public class ThreadStateChecker {

    public void checkThreadState(Object obj) {
        if (obj instanceof Thread thread) {
            System.out.println("Thread state: " + thread.getState());
        } else {
            System.out.println("The provided object is not a Thread.");
        }
    }

}
