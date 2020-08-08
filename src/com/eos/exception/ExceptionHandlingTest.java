package com.eos.exception;

public class ExceptionHandlingTest {

  public static void main(String args[]) {
    try {
      callMethod();
    } catch (Exception ex) {
      System.out.println("Error in method call" + ex);
    }
  }

  private static void callMethod() {
    try {
      int a = 5 / 0;
    }catch (Exception e) {
       throw new RuntimeException("");
    }
  }

}
