package com.eos.test;

public class ClassLoading {

  public static void main(String args[]) {
    A a = new B();
  }

}

class A {

  A() {
    System.out.println("non-static block of super");
  }

  static {
    System.out.println("static block of super");
  }

}

class B extends A {

  B() {
    System.out.println("non-static block of sub");
  }

  static {
    System.out.println("static block of sub");
  }
}

class C{
  static {
    System.out.println("static block of C");
  }
}
