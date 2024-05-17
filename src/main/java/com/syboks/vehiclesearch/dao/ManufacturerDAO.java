package com.syboks.vehiclesearch.dao;

import com.syboks.vehiclesearch.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerDAO extends JpaRepository<Manufacturer, Integer> {
}
