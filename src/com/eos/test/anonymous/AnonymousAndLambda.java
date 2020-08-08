package com.eos.test.anonymous;

public class AnonymousAndLambda {

  public static void main() {
    int a = 5;
    IAnonymous a1 = () -> {
      //int a = 6;
      return 5;
    };

    IAnonymous a2 = new IAnonymous() {
      int i; // Anonymous call can have instance variable
      @Override
      public int calculate() {
        System.out.print(a);
        int a = 6;
        return i;
      }
    };

  }

}


interface IAnonymous {

  public int calculate();


}
