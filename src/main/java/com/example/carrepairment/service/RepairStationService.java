package com.example.carrepairment.service;

import com.example.carrepairment.entity.RepairStation;
import com.example.carrepairment.repository.RepairStationRepository;
import com.example.carrepairment.repository.RepairmentRepository;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RepairStationService {

  private final RepairStationRepository repairStationRepository;
  private final RepairmentRepository repairmentRepository;

  public RepairStation createStation(RepairStation repairStation) {
    return repairStationRepository.save(repairStation);
  }

  public Optional<RepairStation> getStationInformation(String name) {
    return repairStationRepository.findByName(name);
  }

  public int countCarsRepairedOnStation(String name) {
    return repairStationRepository.findByName(name)
        .map(repairmentRepository::countDistinctByRepairStation)
        .orElse(0);
  }

}
