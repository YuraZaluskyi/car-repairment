package com.example.carrepairment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Car {

    @Id
    private String governmentNumber;

    private String manufacturer;

    private String model;

    private int year;

    @OneToMany(mappedBy = "car")
    private List<Repairment> repairments = new ArrayList<>();

    protected void setRepairments(List<Repairment> repairments) {
        this.repairments = repairments;
    }

    public void addRepairments(Repairment repairment) {
        repairments.add(repairment);
        repairment.setCar(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(governmentNumber, car.governmentNumber);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
