package com.example.diskonnect.etollplaza.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Component
public class VehicleRegistrationNumber {
    @NotEmpty
    @NotNull
    private String number;

    public VehicleRegistrationNumber(String number) {
        this.number = number;
    }

    public VehicleRegistrationNumber() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number){
        this.number = number;
    }

    @Override
    public String toString() {
        return "VehicleRegistrationNumber{" +
                "number='" + number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleRegistrationNumber that = (VehicleRegistrationNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
