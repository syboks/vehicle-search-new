package com.syboks.vehiclesearch.dao;

import com.syboks.vehiclesearch.entity.ManufactureYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureYearDAO extends JpaRepository<ManufactureYear, Integer> {
}
