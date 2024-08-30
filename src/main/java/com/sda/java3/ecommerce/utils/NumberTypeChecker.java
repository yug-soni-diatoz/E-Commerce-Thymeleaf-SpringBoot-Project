package com.sda.java3.ecommerce.utils;

public class NumberTypeChecker {

    public void checkNumberType(Object obj) {
        if (obj instanceof Integer) {
            System.out.println("This is an Integer.");
        } else if (obj instanceof Double) {
            System.out.println("This is a Double.");
        } else if (obj instanceof Float) {
            System.out.println("This is a Float.");
        } else {
            System.out.println("Unknown number type.");
        }
    }

}