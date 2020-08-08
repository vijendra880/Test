package com.eos.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

  public static void main(String args[]) {
    List<Integer> firstFiveOddNumber = Stream.iterate(0, n -> n + 1)
        .peek(n -> System.out.println("Peeked " + n)).limit(5).collect(
            Collectors.toList());

    List<String> names = new ArrayList<>(Arrays.asList("abc"));
    List<String> upparCase = names.stream().filter(s -> s.length() != 0).map(String::toUpperCase)
        .collect(Collectors.toList());
    System.out.println(upparCase);
  }

}
