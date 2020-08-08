package com.eos.design.pattern;

/*
Proxy pattern is used to provide a proxy interface to client if creation of real interface is costly
 */

public class ProxyPattern {

  public static void main(String args[]) {

    Iparser parser = new ProxyParser("abc.doc");
    //First time it will do costly operation
    parser.display();
    //No need to do costly operation as it has been loaded already
    parser.display();

  }

}

interface Iparser {

  void display();
}


/*
Real parser that proxy will use
 */
class RealParser implements Iparser {

  private String fileName;


  RealParser(String fileName) {
    this.fileName = fileName;
    //some expensive logic to load file
    loadFromDisk();
  }

  @Override
  public void display() {
    System.out.println("Dispalying " + fileName);
  }

  public void loadFromDisk() {
    System.out.println("loading file from disk");
  }
}

/*
Proxy parser that client will use to avoid load file from disk again and again
 */

class ProxyParser implements Iparser {

  private Iparser parser;
  private String fileName;

  public ProxyParser(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void display() {
    if (parser == null) {
      parser = new RealParser(fileName);
    }
    parser.display();
  }
}
