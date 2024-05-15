package com.syboks.vehiclesearch.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.tool.schema.spi.SchemaTruncator;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="manufacturer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="manufacturer_name")
    private String manufacturerName;
    @Column(name="country_of_origin")
    private String countryOfOrigin;
}
