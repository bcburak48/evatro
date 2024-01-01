package com.evatro.burak.service;

import com.evatro.burak.model.CityTemperature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureServiceTest {

    private TemperatureService service;

    @BeforeEach
    void setUp() throws IOException {
        service = new TemperatureService();
        service.init();
    }

    @Test
    void getTemperature_existingCity_returnsCityTemperature() {
        Optional<CityTemperature> result = service.getTemperature("Istanbul");
        assertTrue(result.isPresent());
        assertEquals("8", result.get().getTemperature());
    }

    @Test
    void getTemperature_nonExistingCity_returnsEmpty() {
        Optional<CityTemperature> result = service.getTemperature("NonExistingCity");
        assertFalse(result.isPresent());
    }
}