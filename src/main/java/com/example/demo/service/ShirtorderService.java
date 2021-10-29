package com.example.demo.service;

import com.example.demo.model.Shirtorder;
import com.example.demo.repository.ShirtorderRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class ShirtorderService{

  private final ShirtorderRepo repo;

  public ShirtorderService(ShirtorderRepo repo) {
    this.repo = repo;
  }

  public  Shirtorder save(Shirtorder item) {
    return repo.save(item);
  }

  public void deleteById(Integer id) {
      repo.deleteById(id);
  }

  public Optional<Shirtorder> findById(Integer id) {
    return repo.findById(id);
  }

  public Iterable<Shirtorder> findAll() {
    return repo.findAll();
  }

  public Page<Shirtorder> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
