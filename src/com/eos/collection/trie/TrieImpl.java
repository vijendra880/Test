package com.eos.collection.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieImpl {

  private Node head;

  public TrieImpl() {
    head = new Node('0');
  }

  public void insert(String data) {
    Node temp = head;
    for (int i = 0; i < data.length(); i++) {
      char ch = data.charAt(i);
      Map<Character, Node> map = temp.map;
      Node node = map.get(ch);
      if (node == null) {
        node = new Node(ch);
        map.put(ch, node);
      }
      temp = node;
    }
    temp.isEnd = true;

  }

  public boolean search(String data) {
    Node temp = head;
    for (int i = 0; i < data.length(); i++) {
      char ch = data.charAt(i);
      Map<Character, Node> map = temp.map;
      Node node = map.get(ch);
      if (node == null) {
        return false;
      }
      temp = node;
    }
    return (temp != null && temp.isEnd);
  }

}

class Node {

  public char ch;
  Map<Character, Node> map;
  boolean isEnd;

  public Node(char ch) {
    this.ch = ch;
    map =new HashMap<>();
  }
}

class Driver {

  public static void main(String args[]) {
    String[] str = {"cat", "cate"};
    TrieImpl trie = new TrieImpl();
    for (int i = 0; i < str.length; i++) {
      trie.insert(str[i]);
    }
    System.out.print("Found :"+trie.search("cater"));
  }
}
