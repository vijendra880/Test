package com.eos.multiThread;

public class OddEven {

  public static void main(String args[]) {
    ResultClass instance = new ResultClass(true);
    Thread oddThread = new Thread(() -> instance.printOdd());
    Thread evenThread = new Thread(() -> instance.printEven());
    oddThread.start();
    evenThread.start();
  }

}

class ResultClass {

  int i = 1;
  int limit = 2;
  private boolean isOdd;

  ResultClass(boolean isOdd) {
    this.isOdd = isOdd;
  }

  public void printOdd() {
    while (i < limit) {
      synchronized (this) {
        while (!isOdd) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(i++);
        isOdd = false;
        notify();
      }
    }
  }

  public void printEven() {
    while (i < limit) {
      synchronized (this) {
        while (isOdd) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(i++);
        isOdd = true;
        notify();
      }
    }
  }
}