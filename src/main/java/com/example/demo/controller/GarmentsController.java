package com.example.demo.controller;

import com.example.demo.model.Garments;
import com.example.demo.service.GarmentsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class GarmentsController {

  private final GarmentsService service;

  public GarmentsController(GarmentsService service) {
    this.service = service;
  }

  @PostMapping(value="/garments",produces = MediaType.APPLICATION_JSON_VALUE)
  public Garments save(@RequestBody Map<String,Object> dto){
    ObjectMapper mapper = new ObjectMapper();
    return this.service.save(mapper.convertValue(dto,Garments.class));
  }

  @GetMapping(value = "/garments/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Garments> findById(@PathVariable("id") String id ){
    return this.service.findById(Integer.valueOf(id));
  }

  @GetMapping(value = "/garments",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Garments> findAll(){
    return this.service.findAll();
  }

  @DeleteMapping(value = "/garments/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(Integer.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/garments/search"}, produces = { "application/json" })
  public Page<Garments> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
    return this.service.search(searchTerm,PageRequest.of(page,limit));
  }
}
