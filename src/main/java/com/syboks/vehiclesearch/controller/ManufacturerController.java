package com.syboks.vehiclesearch.controller;

import com.syboks.vehiclesearch.entity.Manufacturer;
import com.syboks.vehiclesearch.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }
    @PostMapping
    public ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer){
        Manufacturer dbRecord= manufacturerService.saveManufacturer(manufacturer);
        return new ResponseEntity<>(dbRecord, HttpStatus.CREATED);
    }

   @GetMapping
    public ResponseEntity<List<Manufacturer>> getAllManufacturer(){
        List<Manufacturer> savedManufacturers=manufacturerService.fetchAllManufacturers();
        return ResponseEntity.status(HttpStatus.OK).body(savedManufacturers);
    }
}
