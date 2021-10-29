package com.example.demo.service;

import com.example.demo.model.Inkcolor;
import com.example.demo.repository.InkcolorRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class InkcolorService{

  private final InkcolorRepo repo;

  public InkcolorService(InkcolorRepo repo) {
    this.repo = repo;
  }

  public  Inkcolor save(Inkcolor item) {
    return repo.save(item);
  }

  public void deleteById(Integer id) {
      repo.deleteById(id);
  }

  public Optional<Inkcolor> findById(Integer id) {
    return repo.findById(id);
  }

  public Iterable<Inkcolor> findAll() {
    return repo.findAll();
  }

  public Page<Inkcolor> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
