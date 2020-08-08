package com.eos.test.multiThread;

import java.util.ArrayList;
import java.util.List;

public class IteratorFailFastTest {

  private List<Integer> list = new ArrayList<>();

  public IteratorFailFastTest() {
    for (int i = 0; i < 10000; i++) {
      list.add(i);
    }
  }

  public void runUpdateThread() {
    new Thread(() -> {
      for (int i = 10000; i < 20000; i++) {
        list.add(i);
      }
    }).start();
  }

  public void runIteratorThread() {
    new Thread(new Runnable() {
      public void run() {
        for (int i : list) {
          System.out.print(i);
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }).start();
  }

  public static void main(String args[]) {
    IteratorFailFastTest test = new IteratorFailFastTest();
    test.runIteratorThread();
    test.runUpdateThread();
    test.checkLocalReferenceThreadSafey();
  }

  private void checkLocalReferenceThreadSafey() {

  }

}
