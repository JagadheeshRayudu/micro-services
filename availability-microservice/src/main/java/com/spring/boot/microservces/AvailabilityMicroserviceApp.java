package com.spring.boot.microservces;

import com.spring.boot.microservces.availability.dto.AvailabilityCheck;
import com.spring.boot.microservces.dao.AvailabilityCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AvailabilityMicroserviceApp {
    @Autowired
    private AvailabilityCheckRepository repository;
    private static List<AvailabilityCheck> availabilityCheckList = new ArrayList<>();
    static {
        AvailabilityCheck object_1 = AvailabilityCheck.builder()
                .item_name("Watch")
                .quantity(10)
                .build();
        AvailabilityCheck object_2 = AvailabilityCheck.builder()
                .item_name("Shirt")
                .quantity(8)
                .build();
        AvailabilityCheck object_3 = AvailabilityCheck.builder()
                .item_name("Pen")
                .quantity(15)
                .build();
        availabilityCheckList.add(object_1);
        availabilityCheckList.add(object_2);
        availabilityCheckList.add(object_3);
    }
    public static void main(String[] args) {
        SpringApplication.run(AvailabilityMicroserviceApp.class,args);
    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            repository.saveAll(availabilityCheckList);
        };
    }
}