package com.inventarymanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventarymanagement.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>
{

    Optional<Product>findByProductName(String productName);
	List<Product> findAll();
	 List<Product> findByStockQuantityLessThan(int threshold);
}
