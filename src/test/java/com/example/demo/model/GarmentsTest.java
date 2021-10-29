package com.example.demo.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class GarmentsTest {

  @Test
  void shouldCreateGarments(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Garments.class));
  }

  @Test
  void shouldBuildGarments(){
    Assertions.assertNotNull(Garments.builder().build());
  }
}
