package com.example.carrepairment.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.carrepairment.entity.Car;
import com.example.carrepairment.entity.RepairStation;
import com.example.carrepairment.entity.Repairment;
import com.example.carrepairment.factory.RepairStationFactory;
import com.example.carrepairment.factory.RepairmentFactory;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class RepairmentRepositoryTest {

  @Autowired
  private RepairmentRepository repairmentRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  @Test
  void countDistinctByRepairStation() {
    List<RepairStation> repairStations = prepareDatabase();
    int expected = (int) repairStations.get(0).getRepairments().stream().map(i -> i.getCar())
        .distinct()
        .count();
    int actual = repairmentRepository.countDistinctByRepairStation(repairStations.get(0));
    assertEquals(expected, actual);
  }

  @Test
  void findAllRepairmentByCarNumber() {
    List<Repairment> list = prepareDatabase2();
    List<Repairment> actual = repairmentRepository.findAllRepairmentByCarNumber(
        "111111");
    org.assertj.core.api.Assertions.assertThat(actual).usingRecursiveComparison()
        .isEqualTo(list);

  }


  private List<RepairStation> prepareDatabase() {
    RepairStation station = RepairStationFactory.getStation("station").get();
    RepairStation station1 = RepairStationFactory.getStation("station1").get();
    station.setId(null);
    station1.setId(null);
    testEntityManager.persistAndFlush(station);
    testEntityManager.persistAndFlush(station1);
    return List.of(station, station1);
  }

  private List<Repairment> prepareDatabase2() {
    List<Repairment> listRepairment = RepairmentFactory.getRepairments();
    Repairment repairment1 = listRepairment.get(0);
    Repairment repairment2 = listRepairment.get(1);
    repairment1.setId(null);
    repairment2.setId(null);
    Repairment repairment = new Repairment();
    Car car = new Car();
    car.setGovernmentNumber("111111");
    repairment.setCar(car);
    testEntityManager.persistAndFlush(car);
    testEntityManager.persistAndFlush(repairment);
    return List.of(repairment);
  }
}