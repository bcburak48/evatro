package com.evatro.burak.controller;

import com.evatro.burak.model.GenericResponse;
import com.evatro.burak.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TemperatureController {

    private final TemperatureService service;

    @Autowired
    public TemperatureController(TemperatureService service) {
        this.service = service;
    }

    @PostMapping("/temperature")
    public ResponseEntity<GenericResponse> getTemperatureByPost(@RequestBody Map<String, String> request) {
        return createResponse(request.get("query"));
    }

    @GetMapping("/temperature")
    public ResponseEntity<GenericResponse> getTemperatureByGet(@RequestParam String q) {
        return createResponse(q);
    }

    private ResponseEntity<GenericResponse> createResponse(String cityName) {
        return service.getTemperature(cityName)
                .map(temp -> ResponseEntity.ok(new GenericResponse("success", temp, null)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new GenericResponse("failure", null, "City not found")));
    }
}


