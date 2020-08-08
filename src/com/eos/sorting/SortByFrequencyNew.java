package com.eos.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortByFrequencyNew {

  public static void main(String args[]) {
    int[] a = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
    Map<Integer, Node> data = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      Node node = data.get(a[i]);
      if (node == null) {
        node = new Node(i, 1);
      } else {
        node.count += 1;
      }
      data.put(a[i], node);
    }
    Map<Integer, Node> sortedMap = sortMapByValue(data);
    for (Map.Entry<Integer, Node> entry : sortedMap.entrySet()) {
      for (int i = 0; i < entry.getValue().count; i++) {
        System.out.print(", " + entry.getKey());
      }
    }

  }

  private static Map<Integer, Node> sortMapByValue(Map<Integer, Node> data) {
    //create a list of map
    List<Map.Entry<Integer, Node>> list = new ArrayList<>(data.entrySet());
    //sort list based on requierment
    Collections.sort(list, new FrequencyComparator());
    Map<Integer, Node> sortedMap = new LinkedHashMap<>();
    for (Map.Entry<Integer, Node> entry : list) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }
    return sortedMap;
  }
}

class Node {

  int index;
  int count;

  public Node(int index, int count) {
    this.index = index;
    this.count = count;
  }
}

class FrequencyComparator implements Comparator<Map.Entry<Integer, Node>> {

  @Override
  public int compare(Entry<Integer, Node> o1, Entry<Integer, Node> o2) {
    Node n1 = o1.getValue();
    Node n2 = o2.getValue();
    if (n1.count == n2.count) {
      return n1.index - n2.index;
    } else {
      return n2.count - n1.count;
    }
  }
}
