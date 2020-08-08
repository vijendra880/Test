package com.eos.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer<T> is an functional interface which takes input as T and do some operation and return nothing
 */
public class ConsumerExample {

    public static void main(String args[]) {

        //Below consumer will take Integer as input and print that.
        Consumer<Integer> consumer = i -> System.out.println(i);

        List<Integer> list = Arrays.asList(new Integer(1), new Integer(2));
        printList(list, consumer);
    }

    private static void printList(List<Integer> list, Consumer<Integer> lambdaFunctionConsumer) {
        for (Integer i : list) {
            lambdaFunctionConsumer.accept(i);
        }
    }

}


