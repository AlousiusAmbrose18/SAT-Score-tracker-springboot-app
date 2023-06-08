package com.alo.SATScoreTracker.dto;

import lombok.Data;

@Data
public class SatResultDTO {
    private String name;
    private String address;
    private String city;
    private String country;
    private String pinCode;
    private Integer satScore;
    private Boolean passed;

}

