package com.eos.design.pattern;

/*
We use decorator to add extra feature in an object,in below example AddOns class adds fetaure in Coffee object
 */

public class DecoratorPattern {

  public static void main(String args[]) {

    //Simple coffee
    IBeverage beverage = new Coffee();
    System.out.println(beverage.cost());

    //Coffee with Caremal
    IBeverage beverage1 = new Caremal(new Coffee());
    System.out.println(beverage1.cost());

    //Coffee with caremal and cream
    IBeverage beverage2 = new Cream(new Caremal(new Coffee()));
    System.out.println(beverage2.cost());

  }

}

/*
interface to get cost of beverage
 */
interface IBeverage {

  int cost();
}

/*
Implementation of Bevegare with basic coffee
 */

class Coffee implements IBeverage {

  @Override
  public int cost() {
    return 5;
  }
}

/*
interface to add extra feature in coffee or other beverages
 */

abstract class AddOns implements IBeverage {

  protected IBeverage beverage;

}

/*
Addons implementation class isA beverage(to keep all the property(method) of beverage)
and hasA beaverage to add extra feature in current beverage instance and Addon class can not exist without basic class that is coffee
 */

class Caremal extends AddOns {


  public Caremal(IBeverage beverage) {
    this.beverage = beverage;
  }


  @Override
  public int cost() {
    return this.beverage.cost() + 5;
  }
}

class Cream extends AddOns {

  public Cream(IBeverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public int cost() {
    return this.beverage.cost() + 10;
  }
}



