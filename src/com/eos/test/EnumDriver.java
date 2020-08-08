package com.eos.test;

 enum EnumTest {
  INSTANCE_1(),
  INSTANCE_2(),
  INSTANCE_3();

  EnumTest() {
    System.out.println("started");
  }

}

public class EnumDriver {

  public static void main(String args[]) {
    EnumTest.INSTANCE_1.name();
  }
}
