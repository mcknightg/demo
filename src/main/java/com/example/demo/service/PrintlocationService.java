package com.example.demo.service;

import com.example.demo.model.Printlocation;
import com.example.demo.repository.PrintlocationRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class PrintlocationService{

  private final PrintlocationRepo repo;

  public PrintlocationService(PrintlocationRepo repo) {
    this.repo = repo;
  }

  public  Printlocation save(Printlocation item) {
    return repo.save(item);
  }

  public void deleteById(Integer id) {
      repo.deleteById(id);
  }

  public Optional<Printlocation> findById(Integer id) {
    return repo.findById(id);
  }

  public Iterable<Printlocation> findAll() {
    return repo.findAll();
  }

  public Page<Printlocation> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
