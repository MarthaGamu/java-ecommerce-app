package com.example.util;

import com.example.pojo.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Customers, Integer> {
}
