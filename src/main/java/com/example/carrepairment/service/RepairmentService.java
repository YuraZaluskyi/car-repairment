package com.example.carrepairment.service;

import com.example.carrepairment.converter.RepairmentConverter;
import com.example.carrepairment.dto.RepairmentDto;
import com.example.carrepairment.entity.Car;
import com.example.carrepairment.entity.RepairStation;
import com.example.carrepairment.entity.Repairment;
import com.example.carrepairment.repository.CarRepository;
import com.example.carrepairment.repository.RepairStationRepository;
import com.example.carrepairment.repository.RepairmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairmentService {

    private final RepairmentRepository repairmentRepository;
    private final CarRepository carRepository;
    private final RepairStationRepository repairStationRepository;
    private final RepairmentConverter repairmentConverter;

    public Repairment createRepairment(RepairmentDto newRepairment) {
        Car car = carRepository.findById(newRepairment.getCarGovernmentNumber()).orElseThrow(() -> new EntityNotFoundException("Car not found"));
        RepairStation repairStation = repairStationRepository.findById(newRepairment.getRepairStationId()).orElseThrow(() -> new EntityNotFoundException("Repair station not found"));
        Repairment repairment = new Repairment();
        repairment.setId(newRepairment.getId());
        repairment.setRepairDescription(newRepairment.getRepairDescription());
        repairment.setPrice(newRepairment.getPrice());
        car.addRepairments(repairment);
        repairStation.addRepairment(repairment);
        return repairmentRepository.save(repairment);
    }

    public List<Repairment> getAllCarRepairment(String governmentNumber) {
        return repairmentRepository.findAllRepairmentByCarNumber(governmentNumber);
    }

    public long getAllRepairmentsPriceForCar(String governmentNumber) {
        return repairmentRepository.findAllRepairmentByCarNumber(governmentNumber)
                .stream()
                .mapToLong(Repairment::getPrice)
                .sum();
    }
}
