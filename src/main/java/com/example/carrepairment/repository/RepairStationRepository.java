package com.example.carrepairment.repository;

import com.example.carrepairment.entity.RepairStation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepairStationRepository extends CrudRepository<RepairStation, Long> {

    Optional<RepairStation> findByName(String name);
}
