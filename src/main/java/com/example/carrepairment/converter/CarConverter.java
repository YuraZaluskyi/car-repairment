package com.example.carrepairment.converter;

import com.example.carrepairment.entity.Car;
import com.example.carrepairment.dto.CarDto;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    public CarDto convert(Car car) {
        CarDto carDto = new CarDto();
        carDto.setGovernmentNumber(car.getGovernmentNumber());
        carDto.setManufacturer(car.getManufacturer());
        carDto.setModel(car.getModel());
        carDto.setYear(car.getYear());
        return carDto;
    }

    public Car convert(CarDto carDto) {
        Car car = new Car();
        car.setGovernmentNumber(carDto.getGovernmentNumber());
        car.setManufacturer(carDto.getManufacturer());
        car.setModel(carDto.getModel());
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());
        return car;
    }
}
