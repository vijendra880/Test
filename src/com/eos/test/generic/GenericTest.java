package com.eos.test.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericTest {

  public static void main(String args[]) {
    A a = new A();
    a.setA("abc");
    List<Integer> list = new ArrayList<>();
    list.add(1);
    a.setA(list);

    B b = new B(1.0);
    b.setT();
    System.out.println(b.getT());
  }

}

class A {

  public <T> void setA(T t) {
    System.out.println(t.toString());
  }

  public <T> boolean isNull(T t) {
    return Objects.isNull(t);
  }

  public static <T> void setA1(T t) {

  }
}

class B<T> {

  T t;

  public B(T t) {
    this.t = t;
  }


  public void setT() {
    System.out.println(t.toString());
  }

  public T getT() {
    return t;
  }
}
