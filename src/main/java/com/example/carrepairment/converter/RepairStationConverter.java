package com.example.carrepairment.converter;

import com.example.carrepairment.entity.RepairStation;
import com.example.carrepairment.dto.RepairStationDto;
import org.springframework.stereotype.Component;

@Component
public class RepairStationConverter {

    public RepairStationDto convert(RepairStation repairStation) {
        RepairStationDto repairStationDto = new RepairStationDto();
        repairStationDto.setId(repairStation.getId());
        repairStationDto.setName(repairStation.getName());
        repairStationDto.setAddress(repairStation.getAddress());
        return repairStationDto;
    }

    public RepairStation convert(RepairStationDto repairStationDto) {
        RepairStation repairStation = new RepairStation();
        repairStation.setId(repairStationDto.getId());
        repairStation.setName(repairStationDto.getName());
        repairStation.setAddress(repairStationDto.getAddress());
        return repairStation;
    }

}
