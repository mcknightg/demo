package com.example.demo.controller;

import com.example.demo.model.Shirtorder;
import com.example.demo.service.ShirtorderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class ShirtorderController {

  private final ShirtorderService service;

  public ShirtorderController(ShirtorderService service) {
    this.service = service;
  }

  @PostMapping(value="/shirtorder",produces = MediaType.APPLICATION_JSON_VALUE)
  public Shirtorder save(@RequestBody Map<String,Object> dto){
    ObjectMapper mapper = new ObjectMapper();
    return this.service.save(mapper.convertValue(dto,Shirtorder.class));
  }

  @GetMapping(value = "/shirtorder/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Shirtorder> findById(@PathVariable("id") String id ){
    return this.service.findById(Integer.valueOf(id));
  }

  @GetMapping(value = "/shirtorder",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Shirtorder> findAll(){
    return this.service.findAll();
  }

  @DeleteMapping(value = "/shirtorder/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(Integer.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/shirtorder/search"}, produces = { "application/json" })
  public Page<Shirtorder> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
    return this.service.search(searchTerm,PageRequest.of(page,limit));
  }
}
