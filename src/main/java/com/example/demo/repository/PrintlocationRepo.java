package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Printlocation;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintlocationRepo extends MongoRepository<Printlocation, Integer> {
}