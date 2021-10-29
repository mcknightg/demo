package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Garments;
import org.springframework.stereotype.Repository;

@Repository
public interface GarmentsRepo extends MongoRepository<Garments, Integer> {
}