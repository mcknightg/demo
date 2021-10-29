package com.example.demo.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class ShirtorderTest {

  @Test
  void shouldCreateShirtorder(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Shirtorder.class));
  }

  @Test
  void shouldBuildShirtorder(){
    Assertions.assertNotNull(Shirtorder.builder().build());
  }
}
