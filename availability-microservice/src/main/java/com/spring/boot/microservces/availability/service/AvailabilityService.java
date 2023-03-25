package com.spring.boot.microservces.availability.service;

import com.spring.boot.microservces.availability.dto.AvailabilityCheck;
import com.spring.boot.microservces.dao.AvailabilityCheckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailabilityService {
    private final AvailabilityCheckRepository repository;
    public int getQuantity(String itemName) {
        Optional<AvailabilityCheck> quantity_available = repository.findById(itemName);
        if (quantity_available.isPresent()){
            AvailabilityCheck availabilityCheck = quantity_available.get();
            return availabilityCheck.getQuantity();
        }else {
            throw new RuntimeException();
        }

    }
}
