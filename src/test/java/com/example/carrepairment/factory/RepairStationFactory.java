package com.example.carrepairment.factory;

import com.example.carrepairment.entity.Car;
import com.example.carrepairment.entity.RepairStation;
import com.example.carrepairment.entity.Repairment;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import javax.swing.text.html.Option;

public class RepairStationFactory {

  public static RepairStation createStation(RepairStation station) {
    station.setId(1000L);
    station.setName("Repair Station");
    station.setAddress("Address");
    return station;
  }

  public static Optional<RepairStation> getStationInformation(String name) {
    RepairStation station = createStation(new RepairStation());
    station.setName(name);
    return Optional.of(station);
  }

  public static Optional<RepairStation> getStation(String name) {
    Car car1 = new Car();
    car1.setYear(1111);
    car1.setManufacturer("manufactured1");
    car1.setModel("model1");
    car1.setGovernmentNumber("11111111111");

    Car car2 = new Car();
    car2.setYear(2222);
    car2.setManufacturer("manufactured2");
    car2.setModel("model2");
    car2.setGovernmentNumber("2222222222222");

    RepairStation station = new RepairStation();
    station.setName(name);
    station.setId(1000L);
    station.setAddress("Address");

    Repairment repairment1 = new Repairment();
    repairment1.setRepairDescription("RepairDescription1");
    repairment1.setId(100L);
    repairment1.setPrice(10L);
    repairment1.setCar(car1);

    Repairment repairment2 = new Repairment();
    repairment2.setRepairDescription("RepairDescription2");
    repairment2.setId(101L);
    repairment2.setPrice(20L);
    repairment2.setCar(car1);

    Repairment repairment3 = new Repairment();
    repairment3.setRepairDescription("RepairDescription3");
    repairment3.setId(102L);
    repairment3.setPrice(30L);
    repairment3.setCar(car1);

    car1.addRepairments(repairment1);
    car1.addRepairments(repairment2);
    car1.addRepairments(repairment3);
    car2.addRepairments(repairment1);

    station.addRepairment(repairment1);
    station.addRepairment(repairment2);
    station.addRepairment(repairment3);

    return Optional.of(station);
  }

  public static int countCarsRepairedOnStation(String name) {
    RepairStation station = getStation(name).get();
    int count = (int) (station.getRepairments().stream().map(i -> i.getCar()).distinct().count());
    return count;
  }
}
