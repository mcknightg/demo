package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Estimateitem;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimateitemRepo extends MongoRepository<Estimateitem, Integer> {
}