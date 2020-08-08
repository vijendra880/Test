package com.eos.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SortByFrequency {

  public static void main(String args[]) {
    int arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
    sortByFrequency(arr);
  }

  private static void sortByFrequency(int[] a) {
    int n = a.length;
    Element[] elements = new Element[n];
    for (int i = 0; i < n; i++) {
      Element element = new Element();
      element.val = a[i];
      element.count = 0;
      element.index = i;
      elements[i] = element;
    }

    //Sort By Value first to count element frequency
    Arrays.sort(elements, new Comparator<Element>() {
      @Override
      public int compare(Element o1, Element o2) {
        return o1.val - o2.val;
      }
    });
    elements[0].count = 1;
    for (int i = 1; i < n; i++) {
      if (elements[i].val == elements[i - 1].val) {
        elements[i].count = elements[i - 1].count + 1;
        elements[i].index = elements[i - 1].index;
        elements[i - 1].count = -1;
      } else {
        elements[i].count = 1;
      }
    }
   // Arrays.sort(elements,new IndexAndCountComparator());
    for (int i = 0; i < n; i++) {
      System.out.println(elements[i].val);
    }
  }

}

class Element {

  int val;
  int index;
  int count;
}

class IndecAndCountComparator implements Comparator<Element>{

  @Override
  public int compare(Element o1, Element o2) {
    return 0;
  }
}
