package com.evatro.burak.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityTemperature {
    private String name;
    private String temperature;
    private String unit;
}