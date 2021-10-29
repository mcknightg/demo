package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Expenses;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepo extends MongoRepository<Expenses, Integer> {
}