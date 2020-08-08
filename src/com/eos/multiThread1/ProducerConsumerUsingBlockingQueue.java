package com.eos.multiThread1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerUsingBlockingQueue {

  public static void main(String args[]) {
    BlockingQueue queue = new LinkedBlockingDeque();
    new Thread(() -> new Producer(queue).produce()).start();
    new Thread(() -> new Consumer(queue).consume()).start();
  }

}

class Producer {

  private BlockingQueue queue;

  public Producer(BlockingQueue queue) {
    this.queue = queue;
  }

  public void produce() {
    for (int i = 0; i < 10; i++) {
      try {
        System.out.println("Produced:" + i);
        queue.put(i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Consumer {

  private BlockingQueue queue;

  public Consumer(BlockingQueue queue) {
    this.queue = queue;
  }

  public void consume() {
    try {
      while (true) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(queue.take());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
