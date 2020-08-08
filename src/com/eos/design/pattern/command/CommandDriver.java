package com.eos.design.pattern.command;

/**
 * This pattern segregate invoker[Remote] and receiver[Light],Command interface decouples them.
 * Different command like onCommand offCommand can be used in different invoker like tv remote,light
 * remote.
 */
public class CommandDriver {

  public static void main(String args[]) {
    Remote remote = new Remote(new OnCommand(new Light()), new OffCommand(new Light()));
    remote.onLight();
    remote.offLight();
  }
}

/*
Invoker
 */
class Remote {

  private ICommand onCommand;
  private ICommand offCommand;

  public Remote(ICommand onCommand, ICommand offCommand) {
    this.onCommand = onCommand;
    this.offCommand = offCommand;
  }

  public void onLight() {
    this.onCommand.execute();
  }

  public void offLight() {
    this.offCommand.execute();
  }

}

interface ICommand {

  void execute();
}

class OnCommand implements ICommand {

  private Light light;

  public OnCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    this.light.OnLight();
  }
}

class OffCommand implements ICommand {

  private Light light;

  public OffCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    this.light.OffLight();
  }
}

/*
Receiver
 */
class Light {

  public void OnLight() {
    System.out.print("Light on");
  }

  public void OffLight() {
    System.out.println("Light off");
  }

}
