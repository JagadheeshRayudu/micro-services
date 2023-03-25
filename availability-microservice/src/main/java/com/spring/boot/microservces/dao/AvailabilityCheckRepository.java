package com.spring.boot.microservces.dao;

import com.spring.boot.microservces.availability.dto.AvailabilityCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityCheckRepository extends JpaRepository<AvailabilityCheck,String> {
}
