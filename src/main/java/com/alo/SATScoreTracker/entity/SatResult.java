package com.alo.SATScoreTracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class SatResult implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String address;
    private String city;
    private String country;
    private String pinCode;
    private Integer satScore;
    private Boolean passed;

}

