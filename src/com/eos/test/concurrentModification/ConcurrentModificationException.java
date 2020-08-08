package com.eos.test.concurrentModification;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcurrentModificationException {
  public static void main(String args[]){
    List<Integer> list= new ArrayList<>();
    Random rand = new Random();
    int i=rand.nextInt();
    //check();
  }

  private static void check() throws Exception {
    throw new Exception();
  }

}
