package com.eos.multiThread1;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerComsumerUsingLock {

  public static void main(String args[]) {
    SharedResource sharedResource = new SharedResource();
    new Thread(() -> sharedResource.put()).start();
    new Thread(() -> sharedResource.get()).start();
  }

}

class SharedResource {

  private Lock lock = new ReentrantLock();
  private Condition listEmpty = lock.newCondition();
  private Condition listFull = lock.newCondition();
  private Queue<Integer> list = new LinkedList<>();
  private int limit = 5;
  private int count = 0;


  public void put() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      lock.lock();
      while (list.size() == limit) {
        listFull.await();
      }
      list.add(count++);
      listEmpty.signal();
    } catch (Exception e) {

    } finally {
      lock.unlock();
    }
  }

  public void get() {
    lock.lock();
    try {
      while (list.size() == 0) {
        System.out.println("list is empty");
        listEmpty.await();
      }
      System.out.println(list.poll());
      listFull.signal();
    } catch (Exception e) {

    } finally {
      lock.unlock();
    }
  }


}
