package com.eos.java8;

import java.util.function.Consumer;

public class MethodReferenceExample {

    public static void main(String args[]) {
        Domain domain = new Domain();
        setValue(1, domain::setId);
        setValue("Vijendra", domain::setName);
        System.out.println("Id: " + domain.getId() + "Name: " + domain.getName());
    }

    private static <T> void setValue(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }
}

