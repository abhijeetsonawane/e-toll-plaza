package com.example.diskonnect.etollplaza.controller;

import com.example.diskonnect.etollplaza.model.VehicleRegistrationNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vehicles/cross-by")
public class VehicleCrossByRegistrationController {

    @PostMapping("/registration")
    public ResponseEntity<String> registerVehicleCrossBy(@Valid @RequestBody VehicleRegistrationNumber vehicleRegistrationNumber) {
        return ResponseEntity.ok("Registration successful");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
