package com.eos.collection.map;

public class HashMapImpl<K, V> {

  private Entry<K, V>[] bucket;
  private int capacity = 5;
  private int size;

  public HashMapImpl() {
    bucket = new Entry[capacity];
  }

  public V get(K key) {
    int bucketIndex = getIndex(key);
    Entry<K, V> current = bucket[bucketIndex];
    while (current != null) {
      if (current.key.equals(key)) {
        return current.value;
      }
      current = current.next;
    }
    return null;
  }

  public void put(K key, V value) {
    //To Do : use size to increase collection size in some threshold
    int bucketIndex = getIndex(key);
    Entry newNode = new Entry(key, value);
    Entry entry = bucket[bucketIndex];
    if (bucket[bucketIndex] == null) {//if bucketIndex has no entry
      bucket[bucketIndex] = newNode;
      size++;
    } else {
      /*
       * Move current till we reach last node or key is equal to new node key
       * */
      Entry current = bucket[bucketIndex];
      while (current.next != null) {
        if (current.key
            .equals(newNode.key)) { //if key is equal to new node key,update value and return
          current.value = value;
          return;
        }
        current = current.next;
      }
      if (current.key.equals(key)) { //check for last node key
        current.value = value;
      } else { //Add new node in the end of current bucket
        current.next = newNode;
        size++;

      }

    }

  }

  private int getIndex(K key) {
    return key.hashCode() % 5;
  }

  public boolean checkIfContains(K key) {
    Entry node = bucket[getIndex(key)];
    while (node != null) {
      if (node.key.equals(key)) {
        return true;
      }
    }
    return false;
  }

  public int size(){
    return size;
  }

}

class Entry<K, V> {

  public K key;
  public V value;
  public Entry<K, V> next;

  public Entry(K key, V value) {
    this.key = key;
    this.value = value;
  }
}

class DriverClass {

  public static void main(String args[]) {
    HashMapImpl<Integer, String> hashMap = new HashMapImpl<>();
    hashMap.put(1, "abc");
    hashMap.put(2, "xyz");
    hashMap.put(1, "abc_1");
    hashMap.put(6, "abc_6");//same bucket case
    hashMap.put(11, "abc_11");//same bucket case
    System.out.println(hashMap.get(1));
    System.out.println(hashMap.get(2));
    System.out.println(hashMap.get(6));

  }
}




