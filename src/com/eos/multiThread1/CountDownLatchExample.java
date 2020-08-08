package com.eos.multiThread1;

import java.util.concurrent.CountDownLatch;

/*
CountDownLatch is used to make main thread await until all child thread completed its task
we can give count while creating countdownLatch main thread will start execute only count is 0
 */
public class CountDownLatchExample {

  public static void main(String args[]) {
    CountDownLatch countDownLatch = new CountDownLatch(2);
    new Thread(() -> {
      System.out.println("Decreasing 1");
      countDownLatch.countDown();
    }).start();
    new Thread(() -> {
      System.out.println("Decreasing 2");
      countDownLatch.countDown();
    }).start();
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Starting main service");

  }

}
