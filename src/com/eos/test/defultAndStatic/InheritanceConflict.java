package com.eos.test.defultAndStatic;

public class InheritanceConflict {

  public static void main(String args[]) {
    A2 a2 = new Impl();
    a2.method();
  }

}

interface A1 {

  default void method() {
    System.out.println("A1 method");
  }

}

interface A2 {

  default void method() {
    System.out.println("A2 method");
  }

}

class Impl implements A1, A2 {

  @Override
  public void method() {
    A1.super.method(); //To Avoid conflict
  }
}
