package com.eos.test.serialization;

import java.io.Serializable;

public class SerializationExample {

  public static void main(String args[]) {
    Demo object = new Demo(1, "vijendra");
    SerializationHelper.write(object);
    Demo object1 = SerializationHelper.read();
    System.out.print(object1.name);
  }

}

class Demo implements Serializable {

  /*
  serialVersionUID is used to check during deserialization that if id same as during serialization, for ex -
  if we serialize object with id 1, and then later we if change that to 2 during deserialization then it will
  throw InvalidClassException.

  static and transient field can not be serialized
   */
  private static final long serialVersionUID = 1L;

  public int id;
  public String name;

  public Demo(int id, String name) {
    this.id = id;
    this.name = name;
  }
}

