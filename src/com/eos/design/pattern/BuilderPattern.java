package com.eos.design.pattern;

import com.eos.design.pattern.DummyObject.DummyObjectBuilder;

public class BuilderPattern {

  public static void main(String args[]) {
    DummyObject object = DummyObject.builder().id(1).name("test").build();
    System.out.print(object.getName());
  }
}

class DummyObject {

  private int id;
  private String name;

  public DummyObject(DummyObjectBuilder dummyObjectBuilder) {
    this.id = dummyObjectBuilder.id;
    this.name = dummyObjectBuilder.name;
  }

  public String getName() {
    return this.name;
  }

  public static DummyObjectBuilder builder() {
    return new DummyObjectBuilder();
  }

  static class DummyObjectBuilder {

    private int id;
    private String name;

    public DummyObjectBuilder id(int id) {
      this.id = id;
      return this;
    }

    public DummyObjectBuilder name(String name) {
      this.name = name;
      return this;
    }

    public DummyObject build() {
      DummyObject object = new DummyObject(this);
      return object;
    }
  }

}
