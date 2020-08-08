package com.eos.design.pattern.cor;

public class ChainOfResponsibilityDriver {

  public static void main(String args[]) {
    IHandler loginHandler = new LoginHandler();
    IHandler activityHandler = new ActivityHandler();
    loginHandler.setNext(activityHandler);
    loginHandler.handle();
  }

}

interface IHandler {

  void setNext(IHandler handler);

  void handle();

}

abstract class Handler implements IHandler {

  private IHandler next;

  public void setNext(IHandler handler) {
    this.next = handler;
  }

  public void handle() {
    process();
    if (next != null) {
      next.handle();
    }
  }

  public abstract void process();
}

class LoginHandler extends Handler {

  @Override
  public void process() {
    System.out.println("Processing login");
  }
}

class ActivityHandler extends Handler {

  @Override
  public void process() {
    System.out.println("Processing Activity");
  }
}


