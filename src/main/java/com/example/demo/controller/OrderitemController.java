package com.example.demo.controller;

import com.example.demo.model.Orderitem;
import com.example.demo.service.OrderitemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class OrderitemController {

  private final OrderitemService service;

  public OrderitemController(OrderitemService service) {
    this.service = service;
  }

  @PostMapping(value="/orderitem",produces = MediaType.APPLICATION_JSON_VALUE)
  public Orderitem save(@RequestBody Map<String,Object> dto){
    ObjectMapper mapper = new ObjectMapper();
    return this.service.save(mapper.convertValue(dto,Orderitem.class));
  }

  @GetMapping(value = "/orderitem/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Orderitem> findById(@PathVariable("id") String id ){
    return this.service.findById(Integer.valueOf(id));
  }

  @GetMapping(value = "/orderitem",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Orderitem> findAll(){
    return this.service.findAll();
  }

  @DeleteMapping(value = "/orderitem/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(Integer.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/orderitem/search"}, produces = { "application/json" })
  public Page<Orderitem> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
    return this.service.search(searchTerm,PageRequest.of(page,limit));
  }
}
