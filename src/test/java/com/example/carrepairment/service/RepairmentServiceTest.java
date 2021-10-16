package com.example.carrepairment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.carrepairment.converter.RepairmentConverter;
import com.example.carrepairment.dto.RepairmentDto;
import com.example.carrepairment.entity.Car;
import com.example.carrepairment.entity.RepairStation;
import com.example.carrepairment.entity.Repairment;
import com.example.carrepairment.factory.CarFactory;
import com.example.carrepairment.factory.RepairStationFactory;
import com.example.carrepairment.factory.RepairmentFactory;
import com.example.carrepairment.repository.CarRepository;
import com.example.carrepairment.repository.RepairStationRepository;
import com.example.carrepairment.repository.RepairmentRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RepairmentServiceTest {

  private RepairmentRepository repairmentRepository = mock(RepairmentRepository.class);
  private CarRepository carRepository = mock(CarRepository.class);
  private RepairStationRepository repairStationRepository = mock(RepairStationRepository.class);
  private RepairmentConverter repairmentConverter = mock(RepairmentConverter.class);

  private RepairmentService repairmentService = new RepairmentService(repairmentRepository,
      carRepository, repairStationRepository, repairmentConverter);

  @Test
  void createRepairment() {
    //given
    Repairment repairment = new Repairment();
    RepairmentDto repairmentDto = new RepairmentDto();
    repairmentDto.setCarGovernmentNumber("1000000");
    repairmentDto.setRepairStationId(10L);
    repairmentDto.setPrice(1000L);
    when(carRepository.findById("1000000")).thenReturn(Optional.of(CarFactory.getCar("1000000")));
    when(repairStationRepository.findById(10L)).thenReturn(
        Optional.of(RepairStationFactory.getById(10L)));
    when(repairmentRepository.save(repairment)).thenReturn(RepairmentFactory.getRepairment());

    //when
    Repairment actual = repairmentService.createRepairment(repairmentDto);

    //then
    Repairment expected = new Repairment();
    expected.setPrice(1000L);
    expected.setRepairDescription("repair description");
    expected.setId(100L);
    Car car = new Car();
    car.setManufacturer("manufactured1");
    car.setYear(1111);
    car.setModel("model1");
    car.setGovernmentNumber("1000000");
    expected.setCar(car);
    RepairStation repairStation = new RepairStation();
    repairStation.setAddress("address station");
    repairStation.setName("name station");
    repairStation.setId(10L);
    expected.setRepairStation(repairStation);
    assertEquals(expected, actual);
  }

  @Test
  void getAllCarRepairment() {

    //given
    String governmentNumber = "1000000";
    when(repairmentRepository.findAllRepairmentByCarNumber(governmentNumber)).thenReturn(
        RepairmentFactory.getAllRepairmentByCarNumber(governmentNumber));

    //when
    List<Repairment> actual = repairmentService.getAllCarRepairment(governmentNumber);

    //then
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

    List<Repairment> expected = List.of(repairment1, repairment2, repairment3);
    assertEquals(expected, actual);
  }

  @Test
  void getAllRepairmentsPriceForCar() {

    //given
    String governmentNumber = "1000000";
    when(repairmentRepository.findAllRepairmentByCarNumber(governmentNumber)).thenReturn(
        RepairmentFactory.getAllRepairmentByCarNumber(governmentNumber));

    //when
    Long actual = repairmentService.getAllRepairmentsPriceForCar(governmentNumber);
    System.out.println(actual);

    //then
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

    long expected = 600L;
    assertEquals(expected, actual);
  }
}