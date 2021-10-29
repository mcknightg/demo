package com.example.demo.service;

import com.example.demo.model.Settings;
import com.example.demo.repository.SettingsRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class SettingsService{

  private final SettingsRepo repo;

  public SettingsService(SettingsRepo repo) {
    this.repo = repo;
  }

  public  Settings save(Settings item) {
    return repo.save(item);
  }

  public void deleteById(Integer id) {
      repo.deleteById(id);
  }

  public Optional<Settings> findById(Integer id) {
    return repo.findById(id);
  }

  public Iterable<Settings> findAll() {
    return repo.findAll();
  }

  public Page<Settings> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
