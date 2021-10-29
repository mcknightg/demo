package com.example.demo.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class ClientTest {

  @Test
  void shouldCreateClient(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Client.class));
  }

  @Test
  void shouldBuildClient(){
    Assertions.assertNotNull(Client.builder().build());
  }
}
