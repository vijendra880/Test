package com.eos.collection.set;

import com.eos.collection.map.HashMapImpl;

import java.util.HashMap;

public class HashSetImpl<V> {

  HashMapImpl<V, String> map = new HashMapImpl<>();

  public void add(V value) {
    map.put(value, null);
  }

  public boolean ifContains(V value) {
    return map.checkIfContains(value);
  }

  public int size() {
    return map.size();
  }

}

class Driver {

  public static void main(String args[]) {
    HashSetImpl set = new HashSetImpl();
    set.add(4);
    set.add(5);
    System.out.print(set.size());
    set.add(5);
    set.add(6);
    System.out.print(set.size());
  }
}
