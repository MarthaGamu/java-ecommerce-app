package com.example.util;

import com.example.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface Productrepo extends JpaRepository<Product, Integer>{
}
