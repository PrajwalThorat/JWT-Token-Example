package com.stackroute.cartservice.repository;


import com.stackroute.cartservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends MongoRepository<Product , Integer> {
}
