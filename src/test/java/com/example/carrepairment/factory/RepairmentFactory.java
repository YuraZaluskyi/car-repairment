package com.example.carrepairment.factory;

import com.example.carrepairment.entity.Car;
import com.example.carrepairment.entity.RepairStation;
import com.example.carrepairment.entity.Repairment;
import java.util.List;

public class RepairmentFactory {

  public static List<Repairment> getAllRepairmentByCarNumber(String governmentNumber) {

    Car car1 = new Car();
    car1.setManufacturer("manufactured1");
    car1.setYear(1111);
    car1.setModel("model1");
    car1.setGovernmentNumber("1000000");

    Repairment repairment1 = new Repairment();
    repairment1.setId(1L);
    repairment1.setPrice(100L);
    repairment1.setRepairDescription("Repair description1");
    repairment1.setCar(car1);

    Repairment repairment2 = new Repairment();
    repairment2.setId(2L);
    repairment2.setPrice(200L);
    repairment2.setRepairDescription("Repair description2");
    repairment2.setCar(car1);

    Repairment repairment3 = new Repairment();
    repairment3.setId(3L);
    repairment3.setPrice(300L);
    repairment3.setRepairDescription("Repair description3");
    repairment3.setCar(car1);

    return List.of(repairment1, repairment2, repairment3);
  }


  public static Repairment getRepairment() {
    Repairment repairment = new Repairment();
    repairment.setPrice(1000L);
    repairment.setId(100L);
    repairment.setRepairDescription("repair description");
    Car car = new Car();
    car.setManufacturer("manufactured1");
    car.setYear(1111);
    car.setModel("model1");
    car.setGovernmentNumber("1000000");
    repairment.setCar(car);
    RepairStation repairStation = new RepairStation();
    repairStation.setAddress("address station");
    repairStation.setName("name station");
    repairStation.setId(10L);
    repairment.setRepairStation(repairStation);
    return repairment;
  }

  public static List<Repairment> getRepairments() {
    Repairment repairment = new Repairment();
    repairment.setPrice(1000L);
    repairment.setId(100L);
    repairment.setRepairDescription("repair description");
    Car car = new Car();
    car.setManufacturer("manufactured1");
    car.setYear(1111);
    car.setModel("model1");
    car.setGovernmentNumber("1000000");
    repairment.setCar(car);

    Repairment repairment1 = new Repairment();
    repairment1.setPrice(1010L);
    repairment1.setId(101L);
    repairment1.setRepairDescription("repair description1");
    Car car1 = new Car();
    car1.setManufacturer("manufactured2");
    car1.setYear(2222);
    car1.setModel("model2");
    car1.setGovernmentNumber("2000000");
    repairment1.setCar(car1);
    repairment.setCar(car);

    return List.of(repairment, repairment1);
  }
}
