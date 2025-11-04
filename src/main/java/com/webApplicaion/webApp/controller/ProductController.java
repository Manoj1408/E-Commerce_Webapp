package com.webApplicaion.webApp.controller;

import com.webApplicaion.webApp.model.Product;
import com.webApplicaion.webApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    // By defsult this is GET method
    @RequestMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }


    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public List<Product> addProduct(@RequestBody Product prod){
       return service.addProduct(prod);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product prod){
        return service.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public List<Product> deleteProduct(@PathVariable int prodId){
        return service.deleteProduct(prodId);
    }
}

