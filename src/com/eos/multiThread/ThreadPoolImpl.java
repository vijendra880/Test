package com.eos.multiThread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPoolImpl {

  public static void main(String args[]) {
    ThreadPool pool = new ThreadPool(3);
    for (int i = 0; i < 5; i++) {
      pool.execute(new Task(i));
    }
  }

}

class ThreadPool {

  //Worker thread to execute task
  Worker[] workers;
  //Queue to keep task if all worker threads are busy
  BlockingDeque queue;

  public ThreadPool(int threadCount) {
    this.queue = new LinkedBlockingDeque();
    workers = new Worker[threadCount];
    for (int i = 0; i < threadCount; i++) {
      workers[i] = new Worker();
      workers[i].start();
    }

  }

  public void execute(Task task) {
    synchronized (queue) {
      queue.add(task);
      queue.notify(); //Will notify to the worker when new task comes
    }
  }

  class Worker extends Thread {

    public void run() {
      Task task;
      while (true) {
        synchronized (queue) {
          while (queue.isEmpty()) {
            try {
              queue.wait(); // will wait till new task comes
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          task = (Task) queue.poll();
          task.run();
        }
      }
    }
  }

}

class Task implements Runnable {

  private int taskId;

  public Task(int taskId) {
    this.taskId = taskId;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " " + taskId);
  }
}


