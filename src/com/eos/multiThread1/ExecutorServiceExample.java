package com.eos.multiThread1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

  public static void main(String args[]) {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    while (true) {
      System.out.println("All previous job finished");
      Collection taskList = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
        Task task = new Task();
        taskList.add(task);
      }
      try {
        executorService.invokeAll(taskList);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

}

class Task implements Callable {

  @Override
  public Boolean call() throws Exception {
    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0) {
        Thread.sleep(1000);
      }
      System.out.println("Thread-" + Thread.currentThread().getName() + " Index" + i);
    }
    return false;
  }
}
