package com.eos.lru;

import java.util.HashMap;
import java.util.Map;

public class LruImpl {

  private Map<Integer, Node> map = new HashMap<>();// to search efficiently if node is already inserted
  public Node head; // will point to least recently used node
  private Node end; // will point to oldest added node
  private int capacity = 3;

  public void put(int key, String value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.value = value;
      remove(node);
      setHead(node);
    } else {
      Node node = new Node(key, value);
      if (map.size() >= capacity) {
        map.remove(end.key);
        remove(end);
      }
      setHead(node);
      map.put(key, node);
    }

  }

  private void remove(Node node) {
    if (node.prev == null) { // check if node is head
      head = node.next;
    } else {
      node.prev.next = node.next;
    }
    if (node.next == null) {// check if node is last node
      end = node.prev;
    } else {
      node.next.prev = node.prev;
    }
  }

  private void setHead(Node node) {
    node.next = head;
    node.prev = null;
    if (head != null) { // if head already exist
      head.prev = node;
    }
    head = node;
    if (end == null) { // to check if first node is added
      end = node;
    }
  }

  public String get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      remove(node);
      setHead(node);
      return node.value;
    }
    return null;
  }
}

class Node {

  public int key; //key is mapped with page id
  public String value;//It can be any object
  public Node next;
  public Node prev;

  public Node(int key, String value) {
    this.key = key;
    this.value = value;
  }
}

class Driver {

  public static void main(String args[]) {
    LruImpl lru = new LruImpl();
    lru.put(1, "page1");
    lru.put(2, "page2");
    lru.put(3, "page3");
    print(lru.head);
    lru.put(1, "page1"); // now 1 should be head
    print(lru.head);
    lru.put(4, "page4"); // 4 should be head, and 2 to be removed
    print(lru.head);
  }

  public static void print(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.key + ",");
      temp = temp.next;
    }
    System.out.println();
  }
}
