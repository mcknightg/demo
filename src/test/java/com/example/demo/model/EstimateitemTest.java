package com.example.demo.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class EstimateitemTest {

  @Test
  void shouldCreateEstimateitem(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Estimateitem.class));
  }

  @Test
  void shouldBuildEstimateitem(){
    Assertions.assertNotNull(Estimateitem.builder().build());
  }
}
