package com.als.order.service;

import com.als.order.exceptions.OrderNotFoundException;
import com.als.order.model.Order;
import com.als.order.repository.OrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public void addOrder(Order order) {
        Order order1 = orderRepository.save(order);
        new ResponseEntity<Order>(order1, HttpStatus.CREATED);
    }

    public Optional<Order> retrieveOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) throw new OrderNotFoundException("This order doesn't exist");
        return order;

    }

}
