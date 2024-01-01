package com.evatro.burak.controller;

import com.evatro.burak.model.CityTemperature;
import com.evatro.burak.service.TemperatureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TemperatureControllerTest {

    @Mock
    private TemperatureService service;

    @InjectMocks
    private TemperatureController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getTemperatureByGet_whenCityExists_returnsTemperature() throws Exception {
        given(service.getTemperature("Istanbul")).willReturn(Optional.of(new CityTemperature("Istanbul", "8", "celcius")));

        mockMvc.perform(get("/temperature?q=Istanbul")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.temperature").value("8"))
                .andExpect(jsonPath("$.data.name").value("Istanbul"));
    }

    @Test
    void getTemperatureByGet_whenCityDoesNotExist_returnsNotFound() throws Exception {
        given(service.getTemperature("NonExistingCity")).willReturn(Optional.empty());

        mockMvc.perform(get("/temperature?q=NonExistingCity")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}

