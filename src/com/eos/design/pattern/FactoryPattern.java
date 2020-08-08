package com.eos.design.pattern;

public class FactoryPattern {

  public static void main(String args[]) {
    IShape shape1 = Factory.getInstance("circle");
    shape1.getMessage();

    IShape shape2 = Factory.getInstance("triangle");
    shape2.getMessage();

  }

}

interface IShape {

  void getMessage();
}

class CircleShape implements IShape {

  @Override
  public void getMessage() {
    System.out.println("Circle object created");
  }
}

class TriangleShape implements IShape {

  @Override
  public void getMessage() {
    System.out.println("Triangle object created");
  }
}

class Factory {

  public static IShape getInstance(String shapeType) {
    IShape shape = null;
    if (shapeType == "circle") {
      shape = new CircleShape();
    } else if (shapeType == "triangle") {
      shape = new TriangleShape();
    }
    return shape;
  }
}


