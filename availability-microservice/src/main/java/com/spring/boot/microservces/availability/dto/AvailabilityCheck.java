package com.spring.boot.microservces.availability.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quantity_check_tbl")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityCheck {
    @Id
    private String item_name;
    private int quantity;
}
