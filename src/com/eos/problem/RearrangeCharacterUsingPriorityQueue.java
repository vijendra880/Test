package com.eos.problem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrangeCharacterUsingPriorityQueue {

  public static void main(String args[]) {
    String str = "bbba";
    rearrange(str);
  }

  private static void rearrange(String str) {
    int[] count = new int[26];
    for (int i = 0; i < str.length(); i++) {
      count[str.charAt(i) - 'a']++;
    }
    PriorityQueue<Key> queue = new PriorityQueue<Key>(new KeyComparator());
    for (char i = 'a'; i <= 'z'; i++) {
      if (count[i - 'a'] > 0) {
        queue.add(new Key(i, count[i - 'a']));
      }
    }
    String res = "";
    Key prev = new Key('#', -1);
    while (!queue.isEmpty()) {
      Key key = queue.poll();
      res += key.ch;
      if (prev.count > 0) {
        queue.add(prev);
      }
      key.count--;
      prev = key;
    }
    if (res.length() != str.length()) {
      System.out.print("Not possible");
    } else {
      System.out.println(res);
    }
  }

}

class Key {

  char ch;
  int count;

  public Key(char ch, int count) {
    this.ch = ch;
    this.count = count;
  }
}

class KeyComparator implements Comparator<Key> {

  public int compare(Key key1, Key key2) {
    return key2.count - key1.count;
  }

}
