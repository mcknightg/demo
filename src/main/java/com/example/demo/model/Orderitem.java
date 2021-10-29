package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Orderitem {

	@Id
	private Integer id;
	private String xs;
	private String sm;
	private String med;
	private String lg;
	private String xl;
	private String xxl;
	private String xxxl;
	private String xxxxl;
	private String ythxs;
	private String ythsm;
	private String ythmed;
	private String ythlg;
	private String ythxl;
	private String ythxxl;
	private Garments garment;
	private Shirtorder shirtorder;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date datedue;
	private String description;
}