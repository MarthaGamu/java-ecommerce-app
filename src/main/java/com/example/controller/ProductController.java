package com.example.controller;

import com.example.common.ApiResponse;
import com.example.dto.ProductDto;
import com.example.pojo.Category;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.addProduct(productDto, category);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    // list all the products
    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> productDtos = productService.listProducts();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteByid/{id}")
    public String deletebyId(@PathVariable("id") int id){
        if(productService.getByid(id).isPresent()) {
            productService.deletebyId(id);
            return "deleted the value " + id;
        }
        else {
            return "data is not found";
        }
    }

    // update a product
    @PostMapping("/update/{productID}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") Integer productID,
                                                     @RequestBody @Valid ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.updateProduct(productID, productDto, category);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Object> getProductsByCategory(@PathVariable("categoryId") int categoryId) {
        Optional<Category> optionalCategory = categoryService.readCategory(categoryId);
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false, "Category not found"), HttpStatus.NOT_FOUND);
        }
        Category category = optionalCategory.get();
        List<ProductDto> productDtos = productService.getProductsByCategory(category);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/sort")
    public ResponseEntity<?> getProductsByCategorySorted(@PathVariable("categoryId") int categoryId,
                                                         @RequestParam boolean ascending) {
        Optional<Category> optionalCategory = categoryService.readCategory(categoryId);
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false, "Category not sorted"), HttpStatus.NOT_FOUND);
        }
        Category category = optionalCategory.get();
        List<ProductDto> productDtos = productService.getProductsByCategorySorted(category, ascending);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

}

