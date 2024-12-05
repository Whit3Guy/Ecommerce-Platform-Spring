package com.whiteStudio.Ecommerce_Platform_Spring.services;

import com.whiteStudio.Ecommerce_Platform_Spring.repositories.OrderRepository;
import com.whiteStudio.Ecommerce_Platform_Spring.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository _rep;

    public List<Order> findAll()
    {
        return _rep.findAll();
    }

    public Optional<Order> findById(Long id)
    {
        return _rep.findById(id);
    }
}
