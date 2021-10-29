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
public class Estimateitem {

	@Id
	private Integer id;
	private String costea;
	private String description;
	private String lg;
	private String med;
	private String sm;
	private String totalcolors;
	private String xl;
	private String xs;
	private String xxl;
	private String xxxl;
	private String xxxxl;
	private String ythlg;
	private String ythmed;
	private String ythsm;
	private String ythxs;
	private String ythxl;
	private Estimate estimate;
	private String garment;
}