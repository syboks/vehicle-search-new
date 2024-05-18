package com.syboks.vehiclesearch.controller;

import com.syboks.vehiclesearch.entity.Manufacturer;
import com.syboks.vehiclesearch.exception.ManufacturerNotFoundException;
import com.syboks.vehiclesearch.exception.MissingFieldException;
import com.syboks.vehiclesearch.service.ManufacturerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> getManufacturers(@PathVariable int id) throws ManufacturerNotFoundException {
        Manufacturer dbManufacturer=manufacturerService.getManufacturerForId(id);
        if(dbManufacturer==null){
            throw new ManufacturerNotFoundException("no manufacture for id "+id);
        }
        return ResponseEntity.ok(dbManufacturer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manufacturer> updateManufacturer(@PathVariable int id, @Valid @RequestBody Manufacturer manufacturer, BindingResult result) throws Exception {
        if(result.hasErrors()){
            List<ObjectError> errors=result.getAllErrors();
            throw new MissingFieldException(errors.get(0).getDefaultMessage());
        }

        Manufacturer updatedManufacturer=manufacturerService.updateManufacturer(id, manufacturer);
        if(updatedManufacturer==null){
            throw new ManufacturerNotFoundException("No manufacturer found for id "+id);
        }
        return new ResponseEntity<>(updatedManufacturer, HttpStatus.OK);
    }



}
