package com.example.carrepairment.factory;

import com.example.carrepairment.entity.Car;
import java.util.List;

public class CarFactory {

  public static Car createCar(Car car) {
    car.setGovernmentNumber("1001");
    car.setModel("model1");
    car.setYear(1111);
    car.setManufacturer("manufacturer1");
    return car;
  }

  public static List<Car> getAllCars() {
    Car car1 = new Car();
    car1.setGovernmentNumber("1001");
    car1.setModel("model1");
    car1.setYear(1111);
    car1.setManufacturer("manufacturer1");

    Car car2 = new Car();
    car2.setGovernmentNumber("1002");
    car2.setModel("model2");
    car2.setYear(2222);
    car2.setManufacturer("manufacturer2");

    Car car3 = new Car();
    car3.setGovernmentNumber("1003");
    car3.setModel("model3");
    car3.setYear(3333);
    car3.setManufacturer("manufacturer3");

    return List.of(car1, car2, car3);
  }
}
