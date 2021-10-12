package com.example.carrepairment.dto;

import lombok.Data;

@Data
public class RepairmentDto {

    private Long id;

    private String repairDescription;

    private Long price;

    private String carGovernmentNumber;

    private Long repairStationId;
}
