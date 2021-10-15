package com.example.carrepairment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.carrepairment.entity.Car;
import com.example.carrepairment.factory.CarFactory;
import com.example.carrepairment.repository.CarRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarServiceTest {

  private CarRepository carRepository = mock(CarRepository.class);
  private CarService carService = new CarService(carRepository);

  @Test
  void createCar() {
    //given
    Car car = new Car();
    when(carRepository.save(car)).thenReturn(CarFactory.createCar(car));

    //when
    Car actual = carService.createCar(car);

    //then
    Car expected = new Car();
    expected.setGovernmentNumber("1001");
    expected.setModel("model1");
    expected.setYear(1111);
    expected.setManufacturer("manufacturer1");
    assertEquals(expected, actual);
  }

  @Test
  void getAllCars() {
    //given
    when(carRepository.findAll()).thenReturn(CarFactory.getAllCars());

    //when
    List<Car> actual = carService.getAllCars();

    //then
    List<Car> expected = new ArrayList<>();
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

    expected = List.of(car1, car2, car3);
    assertEquals(expected, actual);
  }
}