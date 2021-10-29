package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Client {

	@Id
	private Integer id;
	private String city;
	private String email;
	private String name;
	private String phone;
	private String state;
	private String street1;
	private String street2;
	private String zipcode;
}