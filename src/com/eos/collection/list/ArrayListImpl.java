package com.eos.collection.list;

import java.util.Arrays;

public class ArrayListImpl<K> {

  private static final int INITIAL_SIZE = 5;
  private Object arr[];
  private int size;

  public ArrayListImpl() {
    arr = new Object[INITIAL_SIZE];
  }


  public void add(K data) {
    if (size == arr.length) {
      increaseCapacity();
    }
    arr[size++] = data;
  }

  public K get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return (K) arr[index];
  }
  public K remove(int index){
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    K element = (K) arr[index];
    return null;
  }

  private void increaseCapacity() {
    int newSize = arr.length * 2;
    arr = Arrays.copyOf(arr, newSize);
  }

}

class Driver {

  public static void main(String args[]) {
    ArrayListImpl list = new ArrayListImpl();
    list.add(1);
  }
}
