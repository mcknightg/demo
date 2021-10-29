package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Orderitem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderitemRepo extends MongoRepository<Orderitem, Integer> {
}