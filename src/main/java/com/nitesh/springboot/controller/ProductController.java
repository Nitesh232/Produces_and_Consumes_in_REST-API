package com.nitesh.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitesh.springboot.binding.Product;

@RestController
public class ProductController {
	
	@GetMapping(value = "/getProduct", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<Product> getProduct(){
		
		Product pd = new Product();
		
		pd.setProductId(101);
		pd.setProductName("Mouse");
		pd.setProductPrice(2300.09);
		
		return new ResponseEntity<Product>(pd, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getProducts", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<List<Product>> getProducts(){
		
		Product pd = new Product(101, "Mouse", 1500.00);
		Product pd1 = new Product(102, "Laptop", 25000.00);
		Product pd2 = new Product(103, "Monitor", 15000.00);
		Product pd3 = new Product(104, "Remote", 500.00);
		
		List<Product> productList = Arrays.asList(pd, pd1, pd2, pd3);
		
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/setProduct", 
				 consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<String> setProduct(@RequestBody Product pd){
		
		String msg = "Processed setProduct request and saved product to db...";
		System.out.println(msg);
		System.out.println(pd);
		
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/setProducts", 
				 consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<String> setProducts(@RequestBody List<Product> pd){
		
		
		
		String msg = "Processed setProducts for array of product from request and saved product to db...";
		System.out.println(msg);
		//System.out.println(pd);
		
		pd.forEach(x -> {
			System.out.println(x);
		});
		
		//List<Product> productList = Arrays.asList(pd, pd1, pd2, pd3);
		
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

}
