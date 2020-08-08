package com.eos.multiThread1;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

  public static void main(String args[]) {

    Generator sharedResource = new Generator(new ArrayList<>());

    Runnable producerTask = new Runnable() {
      @Override
      public void run() {
        sharedResource.produce();
      }
    };

    Runnable consumerTask = () -> sharedResource.consume();
    new Thread(producerTask).start();
    new Thread(consumerTask).start();
  }

}

class Generator {

  private List<Integer> list;
  int i;
  private int limit = 5;

  public Generator(List<Integer> list) {
    this.list = list;
  }

  public void produce() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    while (true) {
      synchronized (this) {
        while (list.size() == limit) {
          System.out.println("list is full");
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        list.add(i++);
        notify();
      }
    }

  }

  public void consume() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    while (true) {
      synchronized (this) {
        while (list.size() == 0) {
          System.out.println("list is empty");
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(list.size());
        list.remove(0);
        notify();
      }
    }

  }

}
