package com.example.controllers;

import com.example.pojo.Product;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductController {
   @Autowired
    ProductService service;

   @PostMapping("/insert")

    public Product insert(@RequestBody Product product){
       return service.insertProduct(product);
   }
}
