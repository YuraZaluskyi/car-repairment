package com.example.carrepairment.controller;

import com.example.carrepairment.entity.RepairStation;
import com.example.carrepairment.converter.RepairStationConverter;
import com.example.carrepairment.dto.RepairStationDto;
import com.example.carrepairment.service.RepairStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RepairStationController {

    private final RepairStationService repairStationService;
    private final RepairStationConverter repairStationConverter;

    @PostMapping("/repair-station")
    public RepairStationDto createRepairStation(@RequestBody RepairStationDto repairStationDto) {
        RepairStation repairStation = repairStationService.createStation(repairStationConverter.convert(repairStationDto));
        return repairStationConverter.convert(repairStation);
    }

    @GetMapping("/repair-station/{stationName}")
    public RepairStationDto getRepairStation(@PathVariable String stationName) {
        return repairStationService.getStationInformation(stationName).map(repairStationConverter::convert).orElse(null);
    }

    @GetMapping("/repair-station/{stationName}/cars/count")
    public int countCarsOnRepairedOnRepairStation(@PathVariable String stationName) {
        return repairStationService.countCarsRepairedOnStation(stationName);
    }
}
