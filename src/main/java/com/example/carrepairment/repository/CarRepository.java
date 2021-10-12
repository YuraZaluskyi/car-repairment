package com.example.carrepairment.repository;

import com.example.carrepairment.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, String> {
}
