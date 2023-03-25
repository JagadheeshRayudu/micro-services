package com.spring.boot.microservces.controller;

import com.spring.boot.microservces.dto.Order;
import com.spring.boot.microservces.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final Environment env;
    private final OrderService orderService;
    private final RestTemplate restTemplate;

    @GetMapping
    public String get() {
        return env.getProperty("name");
    }

    @PostMapping("/order")
    public ResponseEntity<?> postOrder(@RequestBody Order order) throws URISyntaxException {
        URI uri = new URI("http://localhost:8080/" + order.getItem_name());
        Integer quantity = restTemplate.getForObject(uri, Integer.class);
        if (quantity < order.getQuantity()) {
            return ResponseEntity.badRequest().body("Only " + quantity + " items of these are left");
        } else {
            boolean orderStatus = orderService.postOrder(order);
            if (orderStatus) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.internalServerError().body("Error Occured and Cannot save to Order Database");
            }
        }
    }
}
