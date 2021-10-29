package com.example.demo.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class OrderitemTest {

  @Test
  void shouldCreateOrderitem(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Orderitem.class));
  }

  @Test
  void shouldBuildOrderitem(){
    Assertions.assertNotNull(Orderitem.builder().build());
  }
}
