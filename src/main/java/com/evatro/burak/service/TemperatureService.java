package com.evatro.burak.service;

import com.evatro.burak.model.CityTemperature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@Service
public class TemperatureService {
    private final Map<String, CityTemperature> temperatureData = new HashMap<>();

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<CityTemperature> list = mapper.readValue(
                new ClassPathResource("data.json").getInputStream(),
                new TypeReference<>() {}
        );
        list.forEach(city -> temperatureData.put(city.getName(), city));
    }

    public Optional<CityTemperature> getTemperature(String cityName) {
        return Optional.ofNullable(temperatureData.get(cityName));
    }
}

