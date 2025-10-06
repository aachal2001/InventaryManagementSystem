package com.inventarymanagement.entity;
import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @Column(name = "product_Discription", nullable = false)
	private String productDiscription;
	 
	 @Column(name = "product_Name", nullable = false)
	private String productName;
	
    @Column(name = "stock_quantity", nullable = false) 
	private int stockQuantity;
    
   
    private static Integer lowStockThreshold=50;
	
}
