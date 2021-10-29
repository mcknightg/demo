package com.example.demo.service;

import com.example.demo.model.Garments;
import com.example.demo.repository.GarmentsRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class GarmentsService{

  private final GarmentsRepo repo;

  public GarmentsService(GarmentsRepo repo) {
    this.repo = repo;
  }

  public  Garments save(Garments item) {
    return repo.save(item);
  }

  public void deleteById(Integer id) {
      repo.deleteById(id);
  }

  public Optional<Garments> findById(Integer id) {
    return repo.findById(id);
  }

  public Iterable<Garments> findAll() {
    return repo.findAll();
  }

  public Page<Garments> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
