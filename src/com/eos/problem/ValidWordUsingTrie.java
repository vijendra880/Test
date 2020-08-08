package com.eos.problem;

import java.util.HashMap;
import java.util.Map;

public class ValidWordUsingTrie {

  public static void main(String args[]) {
    String[] dict = {"go", "bat", "me", "eat", "goal", "boy", "run"};
    char arr[] = {'e', 'o', 'b', 'a', 'm', 'g', 'l'};
    Trie trie = new Trie();
    for (int i = 0; i < dict.length; i++) {
      trie.insert(dict[i]);
    }
    boolean[] hash = new boolean[26];
    for (int i = 0; i < arr.length; i++) {
      hash[arr[i] - 'a'] = true;
    }
    printValidWord(trie, hash);
  }

  private static void printValidWord(Trie trie, boolean[] hash) {
    String str = "";
    for (int i = 0; i < 26; i++) {
      Node node = trie.head.map.get((char) (i + 'a'));
      if (hash[i] && node != null) {
        str += (char) (i + 'a');
        searchWord(node, hash, str);
        str = "";
      }
    }
  }

  private static void searchWord(Node node, boolean[] hash, String str) {
    if (node.isEnd) {
      System.out.println(str);
    }
    for (int i = 0; i < 26; i++) {
      Map<Character, Node> child = node.map;
      if (hash[i] && child.get((char) (i + 'a')) != null) {
        str += (char) (i + 'a');
        searchWord(child.get((char) (i + 'a')), hash, str);
      }
    }
  }

}

class Trie {

  public Node head;

  Trie() {
    head = new Node('#');
  }

  public void insert(String str) {
    Node temp = head;
    for (int i = 0; i < str.length(); i++) {
      Map<Character, Node> map = temp.map;
      Node node = map.get(str.charAt(i));
      if (node == null) {
        node = new Node(str.charAt(i));
        map.put(str.charAt(i), node);
      }
      temp = node;
    }
    temp.isEnd = true;
  }

}

class Node {

  char ch;
  Map<Character, Node> map;
  boolean isEnd;

  public Node(char ch) {
    this.ch = ch;
    map = new HashMap<>();
  }
}
