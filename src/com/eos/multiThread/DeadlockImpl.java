package com.eos.multiThread;

public class DeadlockImpl {

  public static void main(String args[]) {
    SharedLock s1 = new SharedLock();
    SharedLock s2 = new SharedLock();

    //Thread1 will accquire lock on s1 and will wait for s2;
    Thread thread1 = new Thread(() -> s1.fun1(s2));
    //Thread2 will accquired lock on s2 and will wait for s1
    //Thread1 will not release s1 till it get s2 and Thread2 will not release s2 till it get s1,that will cause to deadlock
    Thread thread2 = new Thread(() -> s2.fun2(s1));
    thread1.start();
    thread2.start();
  }

}

class SharedLock {

  public synchronized void fun1(SharedLock s) {
    System.out.println("Thread1 accquired lock on s1");
    s.fun2(this);
    System.out.println("Thread1 waiting for lock on s2");
  }

  public synchronized void fun2(SharedLock s) {
    System.out.println("Thread1 accquired lock on s2");
    s.fun1(this);
    System.out.println("Thread1 waiting for lock on s1");
  }
}
