package com.eos.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPoolImpl {

  public static void main(String args[]) {
    ThreadPool threadPool = new ThreadPool(5);
    for (int i = 0; i < 100; i++) {
      Task task = new Task();
      threadPool.add(task);
      try {
        Thread.sleep(0);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}

class Task implements Runnable {

  public void run() {
    System.out.println("Thread: " + Thread.currentThread().getName());
  }

}

class ThreadPool {

  int threadCount;
  BlockingQueue<Runnable> queue;
  Worker workers[];

  public ThreadPool(int threadCount) {
    this.threadCount = threadCount;
    queue = new LinkedBlockingDeque();
    workers = new Worker[threadCount];
    for (int i = 0; i < threadCount; i++) {
      workers[i] = new Worker();
      workers[i].start();
    }
  }

  public void add(Task task) {
    synchronized (queue) {
      queue.add(task);
      queue.notify();
    }
  }

  class Worker extends Thread {

    public void run() {
      Runnable task;
      while (true) {
        synchronized (queue) {
          while (queue.isEmpty()) {
            try {
              queue.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }

        }
        task = queue.poll();
        task.run();
      }
    }

  }
}

