package com.als.order.controller;

import com.als.order.model.Order;
import com.als.order.service.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Data
@RequestMapping
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @PostMapping(value = "/orders")
    public void makeOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }

    @GetMapping(value = "/orders/{id}")
    public Optional<Order> takeOrder(@PathVariable("id") Long id) {
        return orderService.retrieveOrder(id);
    }
}
