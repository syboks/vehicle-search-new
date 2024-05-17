package com.syboks.vehiclesearch.service.impl;

import com.syboks.vehiclesearch.dao.ManufacturerDAO;
import com.syboks.vehiclesearch.entity.Manufacturer;
import com.syboks.vehiclesearch.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerDAO manufacturerDAO;
    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufacturerDAO.save(manufacturer);
    }

    @Override
    public List<Manufacturer> fetchAllManufacturers() {
        List<Manufacturer> db=manufacturerDAO.findAll();
        return db;
    }

    @Override
    public Manufacturer getManufacturerForId(int id) {
        Optional<Manufacturer> dbManufacturer=manufacturerDAO.findById(id);
        if(dbManufacturer.isPresent()){
            return dbManufacturer.get();
        }
        return null;
    }
}
