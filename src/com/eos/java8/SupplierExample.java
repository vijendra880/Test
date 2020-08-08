package com.eos.java8;

import java.util.function.Supplier;

/**
 * Supplier<T> is a functional interface which takes no input and return result T.
 */
public class SupplierExample {

    public static void main(String args[]) {
        //it will return String and takes no input.
        Supplier<String> supplier = () -> "Hello";
        System.out.println(supplier.get());
    }
}
