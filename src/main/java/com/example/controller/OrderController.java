package com.example.controller;

import com.example.common.ApiResponse;
import com.example.dto.OrderDto;
import com.example.pojo.Order;
import com.example.service.OrderService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addOrder(@RequestBody @Valid Order order) {
        if (userService.findById(order.getUser().getId()).isPresent()) {
            orderService.saveOrder(order);
            return new ResponseEntity<>(new ApiResponse(true, "Order has been added"), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ApiResponse(false, "User not found"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> getOrdersByUserId(@PathVariable("userId") Integer userId) {
        List<OrderDto> orders = orderService.findByUserId(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") Integer id) {
        Optional<OrderDto> order = orderService.findById(id);
        if (order.isPresent()) {
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(false, "Order not found"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ApiResponse> deleteOrderById(@PathVariable("id") Integer id) {
        if (orderService.findById(id).isPresent()) {
            orderService.deleteOrderById(id);
            return new ResponseEntity<>(new ApiResponse(true, "Deleted the order " + id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(false, "Order not found"), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateOrder(@PathVariable("id") Integer id, @RequestBody @Valid Order order) {
        if (orderService.findById(id).isPresent()) {
            order.setId(id);
            orderService.saveOrder(order);
            return new ResponseEntity<>(new ApiResponse(true, "Order has been updated"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(false, "Order not found"), HttpStatus.NOT_FOUND);
        }
    }
}
