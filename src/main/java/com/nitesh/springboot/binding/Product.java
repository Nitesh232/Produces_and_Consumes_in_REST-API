package com.nitesh.springboot.binding;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Product {
	
	
	private Integer productId;
	
	private String productName;
	
	private Double productPrice;
	
	

}
