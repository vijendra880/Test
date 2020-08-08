package com.eos.test.anonymous;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class AnonymousTest1 {

  public static void main(String args[]) {
    InstanceClass test = new InstanceClass();
    test.execute();
  }

}

class InstanceClass {

  public void execute() {
    int a=5;
    System.out.print("Outer" + Thread.currentThread().getName());
    new InnerClass() {
      public void execute() {
        System.out.print("Inner" + Thread.currentThread().getName());
      }
    }.execute();
  }
}

interface InnerClass {

  public void execute();
}
