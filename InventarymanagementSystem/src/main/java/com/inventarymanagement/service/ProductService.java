package com.inventarymanagement.service;

import java.util.List;

import java.util.Optional;

import com.inventarymanagement.entity.Product;


public interface ProductService 
{
	Product register(Product product);
	Optional <Product>  getByProductName(String productName);
	Optional <Product> getProductById(Long productId);
    List<Product> getAll();
    Product updateProductById(Long id,Product productOld);
   // Product updateProductByIdIncrease(Long id,Product productOld);
    void deleteProductById(Long productId);
    Product increaseStock(Long id,int noOfStocks);
    Product decreaseStock(Long id,int noOfStocks);
    List<Product> getLowStockProducts();
}
