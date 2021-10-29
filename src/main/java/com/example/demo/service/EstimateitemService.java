package com.example.demo.service;

import com.example.demo.model.Estimateitem;
import com.example.demo.repository.EstimateitemRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class EstimateitemService{

  private final EstimateitemRepo repo;

  public EstimateitemService(EstimateitemRepo repo) {
    this.repo = repo;
  }

  public  Estimateitem save(Estimateitem item) {
    return repo.save(item);
  }

  public void deleteById(Integer id) {
      repo.deleteById(id);
  }

  public Optional<Estimateitem> findById(Integer id) {
    return repo.findById(id);
  }

  public Iterable<Estimateitem> findAll() {
    return repo.findAll();
  }

  public Page<Estimateitem> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
