package com.example.carrepairment.repository;

import com.example.carrepairment.entity.RepairStation;
import com.example.carrepairment.entity.Repairment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepairmentRepository extends CrudRepository<Repairment, Long> {

    @Query("select r from Repairment r where r.car.governmentNumber = :carNumber")
    List<Repairment> findAllRepairmentByCarNumber(String carNumber);

    int countDistinctByRepairStation(RepairStation repairStation);

}
