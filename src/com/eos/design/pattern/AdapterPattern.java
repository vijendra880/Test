package com.eos.design.pattern;

public class AdapterPattern {

  public static void main(String args[]) {
    //client were used to use this interface i.e OldInterfaceImpl
    OldInterface oldInterface = new OldInterfaceImpl();
    oldInterface.request();

    //But now wants to use new One that is Adaptee
    //So we need to Adapter which will use Adaptee, then CLient can use Adaptee indirectly
    OldInterface newInterface = new Adapter(new AdapteeImpl());
    newInterface.request();
  }

}

/*
 *
 *Old Interface
 * */

interface OldInterface {

  void request();
}

class OldInterfaceImpl implements OldInterface {

  public void request() {
    System.out.print("Old Interface");
  }
}

/**
 * Adapter
 */

class Adapter implements OldInterface {

  private Adaptee adaptee;

  public Adapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public void request() {
    adaptee.newRequest();
  }
}

/*
New Interface
 */

interface Adaptee {

  void newRequest();

}

class AdapteeImpl implements Adaptee {

  @Override
  public void newRequest() {
    System.out.print("New Interface");
  }
}
