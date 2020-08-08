package com.eos.design.pattern;

/*
In strategy pattern context uses different strategy and context and strategy can vary independently
no need to in change context if strategy gets changed
 */
public class Strategy {

  public static void main(String args[]) {
    Calculator calculator = new Calculator(new Addition());
    calculator.doOperation(3, 4);
    calculator = new Calculator(new Subtraction());
    calculator.doOperation(4, 5);

  }

}

/*
Context that uses different strategy
 */
class Calculator {

  private CalculationStrategy calculationStrategy;

  public Calculator(CalculationStrategy calculationStrategy) {
    this.calculationStrategy = calculationStrategy;
  }

  public void doOperation(int a, int b) {
    System.out.print(calculationStrategy.getResult(a, b));
  }
}

/*
Strategies
 */
interface CalculationStrategy {

  int getResult(int a, int b);
}

class Addition implements CalculationStrategy {

  @Override
  public int getResult(int a, int b) {
    return a + b;
  }
}

class Subtraction implements CalculationStrategy {

  @Override
  public int getResult(int a, int b) {
    return a - b;
  }
}
