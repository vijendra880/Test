package com.eos.design.pattern.singleton;


public class SingletonPattern {

  public static void main(String args[]) {
    SingletonEnum singletonEnum = SingletonEnum.getInstance();
    SingletonEnum singletonEnum1 = SingletonEnum.getInstance();
  }

}

/*
Using double locking
when we do instance= new singleton() it will do three thing
1) portion of memory is allocated for instance
2)that memory is initialized object' data
3)instance will point to that memory location

But due to optimization reason compiler might change that order i.e. first it allocate the memory
then point to that memory and then go for initialization.using volatile in this case will prevent such optimization



volatile is used here because suppose if Thread A may assign memomy instance before it finished
constructing instance, Thread will see the assignment and try to use,
in that case it will create a subtle bug because thread B is using partially initialized instance.

For Ex - Thread A has created instance but not assigned a value to its instance variable a.
when Thread B comes it sees instance is not null and it will read the instance without assignment of a.



*/
class SingletonClass {

  private static volatile SingletonClass instance;

  private SingletonClass() {

  }

  public static SingletonClass getInstance() {
    if (instance == null) {
      synchronized (SingletonClass.class) {
        if (instance == null) {
          instance = new SingletonClass();
        }
      }
    }
    return instance;
  }
}

/*
 * Early Initialization - instance will be created as soon as class gets loaded
 * */

class EarlyInitializationExample {

  private static EarlyInitializationExample instance = new EarlyInitializationExample();

  public static EarlyInitializationExample getInstance() {
    return instance;
  }

}

/*
On Demand initialization - instance will be created when inner class gets loaded so instance will not be created
when outer class gets loaded
 */
class OnDemandInitializationExample {

  public static class InstanceHolder {

    private static OnDemandInitializationExample instance = new OnDemandInitializationExample();
  }

  public OnDemandInitializationExample getInstance() {
    return InstanceHolder.instance;
  }
}

/*
Using enum - since enum field is implicitly static and final and INSTANCE will be initialized only once as per
constructor, if we call getInstance method multiple time same instance would be return.
 */

enum SingletonEnum {
  INSTANCE;

  SingletonEnum() {
    System.out.println("Enum initialized");
  }

  public static SingletonEnum getInstance() {
    return INSTANCE;
  }

}
