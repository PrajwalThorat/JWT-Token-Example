package com.stackroute.cartservice.services;

import com.stackroute.cartservice.exception.ProductAlreadyFoundException;
import com.stackroute.cartservice.exception.ProductNotFoundException;
import com.stackroute.cartservice.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product) throws ProductAlreadyFoundException;
    Product updateProduct(Product product) throws ProductNotFoundException;
    Product deleteProduct(int productId);
    List<Product> listAllProducts();
    Product getProductById(int productId);

}
