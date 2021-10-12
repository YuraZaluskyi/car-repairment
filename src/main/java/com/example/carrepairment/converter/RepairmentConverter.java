package com.example.carrepairment.converter;

import com.example.carrepairment.entity.Repairment;
import com.example.carrepairment.dto.RepairmentDto;
import org.springframework.stereotype.Component;

@Component
public class RepairmentConverter {

    public RepairmentDto convert(Repairment repairment) {
        RepairmentDto repairmentDto = new RepairmentDto();
        repairmentDto.setId(repairment.getId());
        repairmentDto.setRepairDescription(repairment.getRepairDescription());
        repairmentDto.setPrice(repairment.getPrice());
        return repairmentDto;
    }

}
