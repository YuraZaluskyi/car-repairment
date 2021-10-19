package com.example.carrepairment.repository;

import com.example.carrepairment.entity.RepairStation;
import com.example.carrepairment.factory.RepairStationFactory;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class RepairStationRepositoryTest {

  @Autowired
  private RepairStationRepository repairStationRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  @Test
  void findByName() {
    List<RepairStation> repairStations = prepareDatabase();
    RepairStation actual = repairStationRepository.findByName("station").get();
    Assertions.assertThat(actual)
        .usingRecursiveComparison()
        .isEqualTo(repairStations.get(0));
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

}
