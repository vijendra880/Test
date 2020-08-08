package com.eos.test.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationHelper {

  public static final String filePath = "/Users/vijendrasingh/Documents/Doc/serialize.txt";

  public static <T> void write(T object) {
    try {
      FileOutputStream outputStream = new FileOutputStream(filePath);
      ObjectOutputStream out = new ObjectOutputStream(outputStream);
      out.writeObject(object);
      out.close();
      outputStream.close();
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }
  }

  public static <T> T read() {
    T object1 = null;
    try {
      FileInputStream inputStream = new FileInputStream(filePath);
      ObjectInputStream input = new ObjectInputStream(inputStream);
      object1 = (T) input.readObject();
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }
    return object1;
  }

}
