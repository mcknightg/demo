package com.example.demo.controller;

import com.example.demo.model.Screen;
import com.example.demo.service.ScreenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class ScreenController {

  private final ScreenService service;

  public ScreenController(ScreenService service) {
    this.service = service;
  }

  @PostMapping(value="/screen",produces = MediaType.APPLICATION_JSON_VALUE)
  public Screen save(@RequestBody Map<String,Object> dto){
    ObjectMapper mapper = new ObjectMapper();
    return this.service.save(mapper.convertValue(dto,Screen.class));
  }

  @GetMapping(value = "/screen/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Screen> findById(@PathVariable("id") String id ){
    return this.service.findById(Integer.valueOf(id));
  }

  @GetMapping(value = "/screen",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Screen> findAll(){
    return this.service.findAll();
  }

  @DeleteMapping(value = "/screen/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(Integer.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/screen/search"}, produces = { "application/json" })
  public Page<Screen> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
    return this.service.search(searchTerm,PageRequest.of(page,limit));
  }
}
