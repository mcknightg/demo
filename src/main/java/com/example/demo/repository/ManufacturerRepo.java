package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Manufacturer;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepo extends MongoRepository<Manufacturer, Integer> {
}