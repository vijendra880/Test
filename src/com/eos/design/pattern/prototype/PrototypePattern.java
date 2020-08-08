package com.eos.design.pattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypePattern {
  public static void main(String args[]){
    ShapeCache.laodCache();

  }

}

abstract class Shape implements Cloneable {

  protected int id;
  protected String type;

  public Object clone() {
    Object clone = null;
    try {
      clone = super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return clone;
  }
}

class Circle extends Shape {

  public Circle() {
    id = 1;
    type = "circle";
  }
}

class Rectangle extends Shape {

  public Rectangle() {
    id = 2;
    type = "rectangle";
  }
}

class ShapeCache {

  private static Map<Integer, Shape> map = new HashMap<>();

  public static void laodCache() {
    map.put(1, new Circle());
    map.put(2, new Rectangle());
  }

  public Shape getShape(int shapeType) {
    Shape shape = map.get(shapeType);
    return (Shape) shape.clone();
  }
}