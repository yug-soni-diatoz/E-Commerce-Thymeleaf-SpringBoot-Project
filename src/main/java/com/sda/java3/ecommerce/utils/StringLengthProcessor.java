package com.sda.java3.ecommerce.utils;

public class StringLengthProcessor {

    /**
     * Processes the input object, checks if it is a String, 
     * and prints the length of the String.
     *
     * @param obj the input object to be processed
     */
    public void process(Object obj) {
        if (obj instanceof String str) {
            int length = str.length();
            System.out.println("The length of the string is: " + length);
        } else {
            System.out.println("The provided object is not a string.");
        }
    }
}
