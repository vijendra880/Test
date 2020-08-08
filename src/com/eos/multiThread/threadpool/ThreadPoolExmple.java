package com.eos.multiThread.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadPoolExmple {

  public static void main(String args[]) {
    try {
    /*
    Thread With Runnable
     */
      new Thread(() ->
          System.out.println("Running runnable interface" + Thread.currentThread().getName()))
          .start();

    /*
    Thread with callable,since Thread class does not support constructor with Callable,
    we need to pass FutureTask in constructor as FutureTask implements Runnable
    Here we are create FutureTask constructor with Callable and passing it to
     */

      new Thread(new FutureTask<>(() -> {
        System.out.println(Thread.currentThread().getName());
        return 0;
      })).start();

    /*
    Executor with Runnable,we used execute method of Executor interface which accept runnable
     */

      Executor executor = Executors.newSingleThreadExecutor();
      executor.execute(
          () -> System.out
              .println(
                  "Running runnable interface with executor" + Thread.currentThread().getName()));

      /*
      ExecutorService with callable since Executor  does not have execute method
       */
      ExecutorService executorService1 = Executors.newSingleThreadExecutor();
      Future future = executorService1.submit(() -> {
        System.out
            .println("Executing Callble with Future return" + Thread.currentThread().getName());
        return 0;
      });
      System.out
          .println(
              "Getting result from Future" + Thread.currentThread().getName() + " Result " + future
                  .get());

    /*
    Executor with callable,we used submit method of ExecutorService which accept Runnable
    we have wrapped callable in FutureTask which implement Runnable and Future,we used Runnable to pass it in execute method while Future
    to get() the result
     */
      FutureTask futureTask = new FutureTask(() -> {
        return 0;
      });
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      executorService.submit(futureTask);
      System.out.println("Getting result from callable using Executor" + futureTask.get());


    } catch (Exception e) {

    }

  }

}


