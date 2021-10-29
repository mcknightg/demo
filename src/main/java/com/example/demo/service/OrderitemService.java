package com.example.demo.service;

import com.example.demo.model.Orderitem;
import com.example.demo.repository.OrderitemRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class OrderitemService{

  private final OrderitemRepo repo;

  public OrderitemService(OrderitemRepo repo) {
    this.repo = repo;
  }

  public  Orderitem save(Orderitem item) {
    return repo.save(item);
  }

  public void deleteById(Integer id) {
      repo.deleteById(id);
  }

  public Optional<Orderitem> findById(Integer id) {
    return repo.findById(id);
  }

  public Iterable<Orderitem> findAll() {
    return repo.findAll();
  }

  public Page<Orderitem> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
