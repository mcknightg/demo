package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Screen;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepo extends MongoRepository<Screen, Integer> {
}