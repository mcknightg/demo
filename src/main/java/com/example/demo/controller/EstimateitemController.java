package com.example.demo.controller;

import com.example.demo.model.Estimateitem;
import com.example.demo.service.EstimateitemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class EstimateitemController {

  private final EstimateitemService service;

  public EstimateitemController(EstimateitemService service) {
    this.service = service;
  }

  @PostMapping(value="/estimateitem",produces = MediaType.APPLICATION_JSON_VALUE)
  public Estimateitem save(@RequestBody Map<String,Object> dto){
    ObjectMapper mapper = new ObjectMapper();
    return this.service.save(mapper.convertValue(dto,Estimateitem.class));
  }

  @GetMapping(value = "/estimateitem/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Estimateitem> findById(@PathVariable("id") String id ){
    return this.service.findById(Integer.valueOf(id));
  }

  @GetMapping(value = "/estimateitem",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Estimateitem> findAll(){
    return this.service.findAll();
  }

  @DeleteMapping(value = "/estimateitem/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(Integer.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/estimateitem/search"}, produces = { "application/json" })
  public Page<Estimateitem> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
    return this.service.search(searchTerm,PageRequest.of(page,limit));
  }
}
