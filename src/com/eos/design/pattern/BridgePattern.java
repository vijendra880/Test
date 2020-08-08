package com.eos.design.pattern;

/*
Bridge patter is used to decouple two different abstraction hierarchy i.e in below example
Shape and Color are two different interface we can combine any of the Shape with any of the Color
so both are varying independently. Without using bridge patter we had to create lots of classes like
RedTriangle,GreenTriangle,RedRectangle,GreenRectangle and if number of  shape or color increases then we have to add classes
and it will increase like if Shape has three type(Circle,Triangle,Rectangle) and Color has four type(Red,Blue,Green,Yellow)
then with bridge pattern we need a+b i.e. 7 class while without bridge we need a*b i.e. 12 class.

 */
public class BridgePattern {

  public static void main(String args[]) {
    Shape redTriangle = new Triangle(new RedColor());
    redTriangle.drawShape();

    Shape greenRectangle = new Rectangle(new GreenColor());
    greenRectangle.drawShape();
  }

}

/*
Shape is a abstraction that will use color to draw different type of shape
 */

abstract class Shape {

  protected Color color;

  public Shape(Color color) {
    this.color = color;
  }

  public abstract void drawShape();

}

class Triangle extends Shape {

  public Triangle(Color color) {
    super(color);
  }

  @Override
  public void drawShape() {
    System.out.print("draw circle");
    this.color.applyColor();
  }
}

class Rectangle extends Shape {

  public Rectangle(Color color) {
    super(color);
  }

  @Override
  public void drawShape() {
    System.out.print("draw rectangle");
    this.color.applyColor();
  }
}

/*

Color implementation will be used by shape
 */

interface Color {

  public void applyColor();
}

class RedColor implements Color {

  @Override
  public void applyColor() {
    System.out.print("Applying Red color");
  }
}

class GreenColor implements Color {

  @Override
  public void applyColor() {
    System.out.print("Applying Green color");
  }
}
