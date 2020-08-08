package com.eos.multiThread;

import java.util.concurrent.locks.ReentrantLock;

public class Locks {

  public static void main(String args[]) {
    Counter counter = new Counter();
    new Thread(() -> counter.getCount()).start();
    new Thread(() -> counter.getCount()).start();
    new Thread(() -> counter.getCount()).start();
  }

}

class Counter {

  ReentrantLock lock = new ReentrantLock();
  private int count = 0;

  public void getCount() {
    try {
      lock.lock();
      System.out.println(count++);
    } catch (Exception e) {
    } finally {
      lock.unlock();
    }
  }
}