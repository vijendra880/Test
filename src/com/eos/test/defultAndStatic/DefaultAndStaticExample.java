package com.eos.test.defultAndStatic;

public class DefaultAndStaticExample {

  public static void main(String args[]) {
    A a = new Implementation();
    B b = new Implementation();
    new Implementation().method();
    C c = new Implementation();
    //D d = new Implementation();
    b.method();
    a.method();
    //d.method();
    c.method();
  }


}

interface A {

  int count = 0;

  default void method() {
    System.out.println("Method A");
    //count++;
  }

  void methodA();

  static void staticMethod() {
    System.out.println("Static Method A");
  }
}

interface B extends A {

  default void method() {
    System.out.println("Method B");
  }

}

interface C{
  default void method() {
    System.out.println("Method C");
  }
}

abstract class D {

  int count;

  public void methodD() {
    System.out.println("Abstract method");
    count++;
  }
}

class Implementation implements A,B,C {

  @Override
  public void methodA() {
    System.out.println("Method A implementation");
  }
  @Override
  public void method(){
      B.super.method();
  }
}


