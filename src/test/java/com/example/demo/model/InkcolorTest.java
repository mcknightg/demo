package com.example.demo.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class InkcolorTest {

  @Test
  void shouldCreateInkcolor(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Inkcolor.class));
  }

  @Test
  void shouldBuildInkcolor(){
    Assertions.assertNotNull(Inkcolor.builder().build());
  }
}
