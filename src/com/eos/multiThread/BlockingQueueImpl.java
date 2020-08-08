package com.eos.multiThread;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueueImpl {

  public static void main(String args[]) {
    SharedResource resource = new SharedResource();
    Runnable producerTask = () -> {
      resource.produce();
    };

    Runnable consumerTask = () -> {
      resource.consume();
    };

    new Thread(producerTask).start();
    new Thread(consumerTask).start();

  }

}

class SharedResource {

  List<Integer> list = new ArrayList<>();
  int data;

  public void produce() {
    while (true) {
      synchronized (this) {
        while (list.size() == 2) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        list.add(data++);
        notify();
      }
    }
  }

  public void consume() {
    while (true) {
      synchronized (this) {
        while (list.size() == 0) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(list.remove(0));
        notify();
      }
    }
  }
}

