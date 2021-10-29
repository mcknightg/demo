package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Settings;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepo extends MongoRepository<Settings, Integer> {
}