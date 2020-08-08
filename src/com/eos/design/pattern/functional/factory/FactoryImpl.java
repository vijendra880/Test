package com.eos.design.pattern.functional.factory;

import java.util.function.Function;

public class FactoryImpl {

    public static void main(String args[]) {
        Vehicle vehicle = VehicleType.CAR.factory.apply(VehicleColor.RED);
    }


}

enum VehicleType {
    CAR(Car::new),
    BUS(Bus::new);

    public final Function<VehicleColor, Vehicle> factory;

    VehicleType(Function<VehicleColor, Vehicle> factory) {
        this.factory = factory;
    }

}

abstract class Vehicle {

    public VehicleColor color;


    public Vehicle(VehicleColor color) {
        this.color = color;
    }
}

class Car extends Vehicle {

    public Car(VehicleColor color) {
        super(color);
    }
}

class Bus extends Vehicle {

    public Bus(VehicleColor color) {
        super(color);
    }
}


enum VehicleColor {
    RED, GREEN;
}


