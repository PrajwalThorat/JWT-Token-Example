package com.stackroute.cartservice.controller;


import com.stackroute.cartservice.exception.ProductAlreadyFoundException;
import com.stackroute.cartservice.exception.ProductNotFoundException;
import com.stackroute.cartservice.model.Product;
import com.stackroute.cartservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws ProductAlreadyFoundException {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deletePersonData(@PathVariable int productId)  {
        return new ResponseEntity<>(productService.deleteProduct(productId) , HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllPersonData(){
        return new ResponseEntity<List<Product>>(productService.listAllProducts() , HttpStatus.OK);
    }
}
