package com.eos.sorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortMapUtility {

  public static void main(String args[]) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 13);
    map.put(7, 3);
    map.put(3, 34);
    map.put(4, 15);
    System.out.println(sortByKey(map));
    System.out.println(sortByValue(map));

  }

  private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
    return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
            LinkedHashMap::new));
  }

  private static Map<Integer, Integer> sortByKey(Map<Integer, Integer> map) {
    return new TreeMap<>(map);
  }

}
