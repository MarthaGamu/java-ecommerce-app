package com.example.dto;

import com.example.pojo.Order;

import java.util.Date;

public class OrderDto {
    private Integer id;
    private UserDto user;
    private Date orderDate;
    private String status;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.user = new UserDto(order.getUser());
        this.orderDate = order.getOrderDate();
        this.status = order.getStatus();
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
