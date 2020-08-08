package com.eos.problem;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramTogether {

  public static void main(String args[]) {
    String s[] = {"cat", "dog", "tac", "god", "act"};
    DupArray dupArray = new DupArray(s, s.length);
    for (int i = 0; i < s.length; i++) {
      char[] ch = s[i].toCharArray();
      Arrays.sort(ch);
      dupArray.words[i].str = new String(ch);
    }
    Arrays.sort(dupArray.words, Comparator.comparing(Word::getStr, (s1, s2) -> {
      return s1.compareTo(s2);
    }));

    for (int i = 0; i < s.length; i++) {
      System.out.print(s[dupArray.words[i].index] + ",");
    }
  }
}

class DupArray {

  Word[] words;

  public DupArray(String[] str, int size) {
    words = new Word[size];
    for (int i = 0; i < size; i++) {
      words[i] = new Word(str[i], i);
    }
  }
}

class Word {

  String str;
  int index;

  public Word(String str, int index) {
    this.str = str;
    this.index = index;
  }

  public String getStr() {
    return str;
  }
}
