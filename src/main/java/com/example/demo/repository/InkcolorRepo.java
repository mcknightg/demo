package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Inkcolor;
import org.springframework.stereotype.Repository;

@Repository
public interface InkcolorRepo extends MongoRepository<Inkcolor, Integer> {
}