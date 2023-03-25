package com.spring.boot.microservces.service;

import com.spring.boot.microservces.dao.OrderRepository;
import com.spring.boot.microservces.dto.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public boolean postOrder(Order order) {
        boolean status = false;
        try {
            orderRepository.save(order);
            status =  true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }
}
