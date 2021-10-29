package com.example.demo.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class PrintlocationTest {

  @Test
  void shouldCreatePrintlocation(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Printlocation.class));
  }

  @Test
  void shouldBuildPrintlocation(){
    Assertions.assertNotNull(Printlocation.builder().build());
  }
}
