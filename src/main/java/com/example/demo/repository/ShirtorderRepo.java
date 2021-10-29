package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Shirtorder;
import org.springframework.stereotype.Repository;

@Repository
public interface ShirtorderRepo extends MongoRepository<Shirtorder, Integer> {
}