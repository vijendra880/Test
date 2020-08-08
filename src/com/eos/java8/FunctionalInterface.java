package com.eos.java8;

public class FunctionalInterface {

  public static void main(String args[]) {

    //Functional interface
    Utility utility = (x) -> x % 2 != 0;
    System.out.println(utility.checkIfOdd(4));

    //Anonymous class
    Utility utility1 = new Utility() {
      public boolean checkIfOdd(int x) {
        return x % 2 != 0;
      }
    };
    System.out.println(utility1.checkIfOdd(4));
  }
}

@java.lang.FunctionalInterface
interface Utility {

  boolean checkIfOdd(int x);

}


