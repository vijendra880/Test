package com.eos.test.exception;

public class TryCatchCheck {

  public static void main(String args[]) throws Exception {
    try {
      try {
        System.out.println("Entered try block");
        throw new RuntimeException();
      } catch (RuntimeException e) {
        System.out.println("Inside first exception");
        throw new Exception("first");
      } catch (Exception e) {
        System.out.println("Inside second exception");
        throw new RuntimeException("second");
      }
    }catch(Exception e){
      System.out.println("Outer exception");
    }
  }

}
