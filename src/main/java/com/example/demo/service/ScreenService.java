package com.example.demo.service;

import com.example.demo.model.Screen;
import com.example.demo.repository.ScreenRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class ScreenService{

  private final ScreenRepo repo;

  public ScreenService(ScreenRepo repo) {
    this.repo = repo;
  }

  public  Screen save(Screen item) {
    return repo.save(item);
  }

  public void deleteById(Integer id) {
      repo.deleteById(id);
  }

  public Optional<Screen> findById(Integer id) {
    return repo.findById(id);
  }

  public Iterable<Screen> findAll() {
    return repo.findAll();
  }

  public Page<Screen> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
