package com.example.carrepairment.factory;

import com.example.carrepairment.entity.RepairStation;
import java.util.Optional;

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
}
