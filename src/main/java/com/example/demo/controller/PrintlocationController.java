package com.example.demo.controller;

import com.example.demo.model.Printlocation;
import com.example.demo.service.PrintlocationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class PrintlocationController {

  private final PrintlocationService service;

  public PrintlocationController(PrintlocationService service) {
    this.service = service;
  }

  @PostMapping(value="/printlocation",produces = MediaType.APPLICATION_JSON_VALUE)
  public Printlocation save(@RequestBody Map<String,Object> dto){
    ObjectMapper mapper = new ObjectMapper();
    return this.service.save(mapper.convertValue(dto,Printlocation.class));
  }

  @GetMapping(value = "/printlocation/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Printlocation> findById(@PathVariable("id") String id ){
    return this.service.findById(Integer.valueOf(id));
  }

  @GetMapping(value = "/printlocation",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Printlocation> findAll(){
    return this.service.findAll();
  }

  @DeleteMapping(value = "/printlocation/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(Integer.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/printlocation/search"}, produces = { "application/json" })
  public Page<Printlocation> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
    return this.service.search(searchTerm,PageRequest.of(page,limit));
  }
}
