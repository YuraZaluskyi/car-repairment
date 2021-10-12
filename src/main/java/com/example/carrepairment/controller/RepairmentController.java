package com.example.carrepairment.controller;

import com.example.carrepairment.converter.RepairmentConverter;
import com.example.carrepairment.dto.RepairmentDto;
import com.example.carrepairment.service.RepairmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RepairmentController {

    private final RepairmentService repairmentService;
    private final RepairmentConverter repairmentConverter;

    @PostMapping("/repairment")
    public RepairmentDto createRepairment(@RequestBody RepairmentDto repairmentDto) {
        return repairmentConverter.convert(repairmentService.createRepairment(repairmentDto));
    }
}
