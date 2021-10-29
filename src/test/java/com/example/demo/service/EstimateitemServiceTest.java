package com.example.demo.service;

import com.example.demo.repository.EstimateitemRepo;
import com.example.demo.model.Estimateitem;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@ExtendWith(SpringExtension.class)
@Scope("test")
class EstimateitemServiceTest {

  @MockBean
  private EstimateitemRepo repo;

  Estimateitem item1;
  Estimateitem item2;
  EstimateitemService service;

  @BeforeEach
  void before(){
    EasyRandom generator = new EasyRandom();
    item1 = generator.nextObject(Estimateitem.class);
    item2 = generator.nextObject(Estimateitem.class);
    service = new EstimateitemService(this.repo);
  }

  @Test
  void shouldSave(){
    Mockito.when(repo.save(Mockito.any(Estimateitem.class))).thenReturn(item1);
    Estimateitem data = service.save(Estimateitem.builder().build());
    Assertions.assertEquals(data,item1);
  }

  @Test
  void findById(){
    Mockito.when(repo.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(item1));
    Assertions.assertNotNull(service.findById(Integer.valueOf("1")));
  }

  @Test
  void deleteById(){
    Assertions.assertAll(() -> service.deleteById(Integer.valueOf("1")));
  }

  @Test
  void findAll(){
    Mockito.when(repo.findAll()).thenReturn(Arrays.asList(item1,item2));
    List<Estimateitem> all = StreamSupport.stream(service.findAll().spliterator(), false).collect(Collectors.toList());
    Assertions.assertEquals(2, all.size());
  }

  @Test
  void search(){
    PageRequest pageRequest = PageRequest.of(1,2);
    Page<Estimateitem> page = new PageImpl<>(Arrays.asList(item1,item2));
    Mockito.when(repo.findAll(pageRequest)).thenReturn(page);
    List<Estimateitem> all = new ArrayList<>(service.search(null, pageRequest).getContent());
    Assertions.assertEquals(2, all.size());
  }

}
