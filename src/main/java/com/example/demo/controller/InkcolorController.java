package com.example.demo.controller;

import com.example.demo.model.Inkcolor;
import com.example.demo.service.InkcolorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class InkcolorController {

  private final InkcolorService service;

  public InkcolorController(InkcolorService service) {
    this.service = service;
  }

  @PostMapping(value="/inkcolor",produces = MediaType.APPLICATION_JSON_VALUE)
  public Inkcolor save(@RequestBody Map<String,Object> dto){
    ObjectMapper mapper = new ObjectMapper();
    return this.service.save(mapper.convertValue(dto,Inkcolor.class));
  }

  @GetMapping(value = "/inkcolor/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Inkcolor> findById(@PathVariable("id") String id ){
    return this.service.findById(Integer.valueOf(id));
  }

  @GetMapping(value = "/inkcolor",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Inkcolor> findAll(){
    return this.service.findAll();
  }

  @DeleteMapping(value = "/inkcolor/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(Integer.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/inkcolor/search"}, produces = { "application/json" })
  public Page<Inkcolor> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
    return this.service.search(searchTerm,PageRequest.of(page,limit));
  }
}
