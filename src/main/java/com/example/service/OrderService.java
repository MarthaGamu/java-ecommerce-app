package com.example.service;

import com.example.dto.OrderDto;
import com.example.pojo.Order;
import com.example.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDto> findByUserId(Integer userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream().map(OrderDto::new).collect(Collectors.toList());
    }

    public Optional<OrderDto> findById(Integer id) {
        return orderRepository.findById(id).map(OrderDto::new);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrderById(Integer id) {
        orderRepository.deleteById(id);
    }
}
