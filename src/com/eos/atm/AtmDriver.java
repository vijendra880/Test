package com.eos.atm;

public class AtmDriver {

  public static void main(String args[]) {
    Atm atm = new Atm();
    atm.insertCard();
    //atm.enterPin();
    atm.cashWithdraw();
  }

}

class Atm {

  private AtmState atmState;

  public Atm() {
    this.atmState = new InsertCardState(this);
  }

  public void insertCard() {
    this.atmState.insertCard();
  }

  public void enterPin() {
    this.atmState.enterPin();
  }

  public void cashWithdraw() {
    this.atmState.cashWithdraw();
  }

  public void changeState(AtmState atmState) {
    this.atmState = atmState;
  }
}


interface AtmState {

  public void insertCard();

  public void enterPin();

  public void cashWithdraw();

}

class InsertCardState implements AtmState {

  private Atm atm;

  public InsertCardState(Atm atm) {
    this.atm = atm;
  }

  @Override
  public void insertCard() {
    System.out.println("Please insert card");
    this.atm.changeState(new EnterPinState(atm));
  }

  @Override
  public void enterPin() {
    System.out.println("Please insert card first");
  }

  @Override
  public void cashWithdraw() {
    System.out.println("Please insert card first");
  }
}

class EnterPinState implements AtmState {

  private Atm atm;

  public EnterPinState(Atm atm) {
    this.atm = atm;
  }

  @Override
  public void insertCard() {
    System.out.println("Please insert card");
    this.atm.changeState(new EnterPinState(atm));
  }

  @Override
  public void enterPin() {
    System.out.println("Please enter pin");
    this.atm.changeState(new CashWithDrawState(atm));
  }

  @Override
  public void cashWithdraw() {
    System.out.println("Please enter pin first");
  }
}

class CashWithDrawState implements AtmState {
  private Atm atm;

  public CashWithDrawState(Atm atm) {
    this.atm = atm;
  }

  @Override
  public void insertCard() {
    System.out.println("Please insert card");
    this.atm.changeState(new EnterPinState(atm));
  }

  @Override
  public void enterPin() {
    System.out.println("Please enter pin");
    this.atm.changeState(new CashWithDrawState(atm));
  }

  @Override
  public void cashWithdraw() {
    System.out.println("Please with cash");
  }
}


