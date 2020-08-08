package com.eos.design.pattern.abstractFactory;

/*
Abstract factory is used to create same set of object from a family of object.In below examaple we are
creating two type of shape large and small using different factory while in factory pattern we use only
one factory class.
Every factory should return same type of instance i.e Shape in below example
 */

public class AbstractFactoryPattern {

  public static void main(String args[]) {
    AbstractFactory factory1 = AbstractFactoryProducer.getFactory("small");
    Shape shape = factory1.getShape("circle");
    shape.getMessage();

    factory1 = AbstractFactoryProducer.getFactory("large");
    shape = factory1.getShape("rectangle");
    shape.getMessage();

  }
}

interface Shape {

  void getMessage();
}

class SmallRectangle implements Shape {

  @Override
  public void getMessage() {
    System.out.println("Small rectangle");
  }
}

class SmallCircle implements Shape {

  @Override
  public void getMessage() {
    System.out.println("small circle");
  }
}

class LargeRectangle implements Shape {

  @Override
  public void getMessage() {
    System.out.println("Large rectangle");
  }
}

class LargeCircle implements Shape {

  @Override
  public void getMessage() {
    System.out.println("large circle");
  }
}

abstract class AbstractFactory {

  abstract Shape getShape(String shapeType);
}

/*
First factory
 */
class LargeShapeFactory extends AbstractFactory {

  @Override
  Shape getShape(String shapeType) {
    Shape shape = null;
    if (shapeType == "circle") {
      shape = new LargeCircle();
    } else if (shapeType == "rectangle") {
      shape = new LargeRectangle();
    }
    return shape;
  }
}

/*
Second Factory
 */

class SmallShapeFactory extends AbstractFactory {

  @Override
  Shape getShape(String shapeType) {

    Shape shape = null;
    if (shapeType == "circle") {
      shape = new SmallCircle();
    } else if (shapeType == "rectangle") {
      shape = new SmallRectangle();
    }
    return shape;
  }
}

class AbstractFactoryProducer {

  public static AbstractFactory getFactory(String type) {
    AbstractFactory factory = null;
    if (type == "small") {
      factory = new SmallShapeFactory();
    } else if (type == "large") {
      factory = new LargeShapeFactory();
    }
    return factory;
  }
}

