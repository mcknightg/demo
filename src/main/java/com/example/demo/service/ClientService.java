package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class ClientService{

  private final ClientRepo repo;

  public ClientService(ClientRepo repo) {
    this.repo = repo;
  }

  public  Client save(Client item) {
    return repo.save(item);
  }

  public void deleteById(Integer id) {
      repo.deleteById(id);
  }

  public Optional<Client> findById(Integer id) {
    return repo.findById(id);
  }

  public Iterable<Client> findAll() {
    return repo.findAll();
  }

  public Page<Client> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
