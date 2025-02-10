package com.example.services;

import  com.example.pojo.Product;
import com.example.util.Productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    Productrepo repo;

    public Product insertProduct(Product product){
        return  repo.save(product);
    }

}
