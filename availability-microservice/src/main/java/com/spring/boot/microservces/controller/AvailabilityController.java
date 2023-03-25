package com.spring.boot.microservces.controller;

import com.spring.boot.microservces.availability.service.AvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AvailabilityController {
    private final AvailabilityService service;

    @GetMapping("/{itemName}")
    public ResponseEntity<?> getQuantity(@PathVariable("itemName") String itemName) {
        try {
            int quantity_available = service.getQuantity(itemName);
            return ResponseEntity.ok().body(quantity_available);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(0);
        }
    }
}
