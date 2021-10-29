package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Estimate;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimateRepo extends MongoRepository<Estimate, Integer> {
}