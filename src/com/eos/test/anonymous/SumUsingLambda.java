package com.eos.test.anonymous;

public class SumUsingLambda {

  public static void main(String args[]) {
    Isum sum = (a, b) -> {
      System.out.print(a + b);
      return a + b;
    };
    System.out.println(sum.calculate(3, 4));
  }

}

interface Isum {

  public int calculate(int a, int b);
}
