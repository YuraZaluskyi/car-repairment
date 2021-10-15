package com.example.carrepairment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.carrepairment.entity.RepairStation;
import com.example.carrepairment.factory.RepairStationFactory;
import com.example.carrepairment.repository.RepairStationRepository;
import com.example.carrepairment.repository.RepairmentRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class RepairStationServiceTest {

  private RepairStationRepository repairStationRepository = mock(RepairStationRepository.class);
  private RepairmentRepository repairmentRepository = mock(RepairmentRepository.class);
  private RepairStationService stationService = new RepairStationService(repairStationRepository,
      repairmentRepository);


  @Test
  void createStation() {
    //given
    RepairStation station = new RepairStation();
    when(repairStationRepository.save(station)).thenReturn(
        RepairStationFactory.createStation(station));

    //when
    RepairStation actual = stationService.createStation(station);

    //then
    RepairStation expected = new RepairStation();
    expected.setId(1000L);
    expected.setName("Repair Station");
    expected.setAddress("Address");
    assertEquals(expected, actual);
  }

  @Test
  void getStationInformation() {
    //given
    String nameStation = "Repair Station";
    when(repairStationRepository.findByName(nameStation)).thenReturn(
        RepairStationFactory.getStationInformation(nameStation));
    //when
    Optional<RepairStation> actual = stationService.getStationInformation(nameStation);

    //then
    RepairStation expectedStation = new RepairStation();
    expectedStation.setId(1000L);
    expectedStation.setName("Repair Station");
    expectedStation.setAddress("Address");
    Optional<RepairStation> expected = Optional.of(expectedStation);
    assertEquals(expected, actual);
  }

  @Test
  void getStationInformationEmptyResult() {
    //given
    String nameStation = "Station";
    when(repairStationRepository.findByName(nameStation)).thenReturn(
        Optional.empty());
    //when
    Optional<RepairStation> actual = stationService.getStationInformation(nameStation);

    //then
    Optional<RepairStation> expected = Optional.ofNullable(null);
    assertEquals(expected, actual);
  }

  @Test
  void countCarsRepairedOnStation() {
    //given
    String nameStation = "Station";

    //when
    when(repairStationRepository.findByName(nameStation)).thenReturn(
        RepairStationFactory.getStation(nameStation));

    when((repairStationRepository.findByName(nameStation)
        .map(repairmentRepository::countDistinctByRepairStation)).get()).thenReturn(
        RepairStationFactory.countCarsRepairedOnStation(nameStation));

    //then
    int actual = stationService.countCarsRepairedOnStation(nameStation);
    int expected = 2;
    assertEquals(expected, actual);
  }
}