package com.whiteStudio.Ecommerce_Platform_Spring.controllers;

import com.whiteStudio.Ecommerce_Platform_Spring.entities.Order;
import com.whiteStudio.Ecommerce_Platform_Spring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    private OrderService service;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable(value = "id") Long id)
    {
        Optional<Order> order = service.findById(id);
        return order.<ResponseEntity<Object>>map(order1 -> ResponseEntity.status(HttpStatus.OK).body(order1)).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found"));
    }

}
