package com.example.carrepairment.controller;

import com.example.carrepairment.entity.Car;
import com.example.carrepairment.converter.CarConverter;
import com.example.carrepairment.dto.CarDto;
import com.example.carrepairment.service.CarService;
import com.example.carrepairment.converter.RepairmentConverter;
import com.example.carrepairment.dto.RepairmentDto;
import com.example.carrepairment.service.RepairmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final CarConverter carConverter;
    private final RepairmentService repairmentService;
    private final RepairmentConverter repairmentConverter;

    @PostMapping("/car")
    public CarDto createCar(@RequestBody CarDto car) {
        Car savedCar = carService.createCar(carConverter.convert(car));
        return carConverter.convert(savedCar);
    }

    @GetMapping("/cars")
    public List<CarDto> getAllCars() {
        return carService.getAllCars().stream().map(carConverter::convert).toList();
    }


    @GetMapping("/car/{carGovernmentNumber}/repairs")
    public List<RepairmentDto> getAllCarRepairments(@PathVariable String carGovernmentNumber) {
        return repairmentService.getAllCarRepairment(carGovernmentNumber).stream().map(repairmentConverter::convert).toList();
    }

    @GetMapping("/car/{carGovernmentNumber}/repairs/cost")
    public long getAllCarRepairmentsCost(@PathVariable String carGovernmentNumber) {
        return repairmentService.getAllRepairmentsPriceForCar(carGovernmentNumber);
    }
}
