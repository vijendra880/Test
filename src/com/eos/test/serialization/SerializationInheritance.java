package com.eos.test.serialization;

import java.io.Serializable;

/*
if child class is implementing Serializable,then in serialization all parent class field  will also be serialized
 */
public class SerializationInheritance {

  public static void main(String args[]) {
    B b = new B();
    b.b2 = "vijendra";
    SerializationHelper.write(b);
    B b1 = SerializationHelper.read();
    System.out.println(b1.b2 + b1.a2);
  }

}

class A {

  private static final long serialVersionUID = 1L;

  public int a1;
  public String a2 = "singh";
}

class B extends A implements Serializable {

  private static final long serialVersionUID = 2L;

  public int b1;
  public String b2;


}
