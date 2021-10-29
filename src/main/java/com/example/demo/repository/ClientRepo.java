package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends MongoRepository<Client, Integer> {
}