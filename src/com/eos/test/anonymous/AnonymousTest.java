package com.eos.test.anonymous;

public class AnonymousTest {

  String shared = "abc";

  public static void main(String args[]) {
    Test test = new Test("ggg");
    test.execute();
    String s = "ffff";
    A a = new A() {
      @Override
      public void getAge() {
        //s="ttt";
      }
    };
    System.out.print(test.text);
    a.getAge();
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
      }
    });
  }

  private static String getValue() {
    return null;
  }
}

interface A {

  int value = 20;

  public void getAge();
}

class Test {

  String text;

  public Test(String a) {
    this.text = a;
  }

  public void set(String s) {
    text = s;
  }

  public void set(Test s) {
    s = null;
  }

  public void execute() {
    String a = "abc";
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.print(a);
        //a="amf";
      }
    });
  }
}

class Check{
  int a1=10;
  public void execute(){
    int a=10;
    new Thread(new Runnable() {
    public void run(){
      System.out.print(a);
      a1=20;
    }
    });
  }
}


