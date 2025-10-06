package com.inventarymanagement.serviceImpl;
import java.util.List;



import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventarymanagement.entity.Product;
import com.inventarymanagement.repo.ProductRepo;
import com.inventarymanagement.service.ProductService;

import CustomException.InsufficientStockException;



@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductRepo prepo;

	@Override
	public Product register(Product product) {
		return prepo.save(product);
	}

	@Override
	public Optional<Product> getProductById(Long productId) {
		return prepo.findById(productId);
	}

	@Override
	public Optional<Product> getByProductName(String product_Name) {
		return prepo.findByProductName(product_Name);
	}

	@Override
	public List<Product> getAll() {
		return prepo.findAll();
	}

	@Override
	public Product updateProductById(Long id,Product product) {
	    Optional<Product> optionalProduct = prepo.findById(id);
	    
	    if (optionalProduct.isPresent()) 
	    {
	        Product existingProduct = optionalProduct.get();
	        existingProduct.setProductDiscription(product.getProductDiscription());
	        existingProduct.setProductName(product.getProductName());
	       
	        existingProduct.setStockQuantity(product.getStockQuantity());
	        
	        return prepo.save(existingProduct);
	    }
	        
	    else {
	        throw new RuntimeException("Product not found with id: " + product.getId());
	   }
	}

	@Override
	public void deleteProductById(Long productId) {
		prepo.deleteById(productId);		
	}

	@Override
	public Product increaseStock(Long id, int amount) {
		Optional<Product> p = prepo.findById(id);
		 if (p.isPresent()) 
		 {
			 Product newProduct = p.get();
			 newProduct.setStockQuantity(newProduct.getStockQuantity()+amount);
			 return prepo.save(newProduct);
		 }
		 else
		 {
		        throw new RuntimeException("Product not found with id: " );
		 }   
    }

	 public Product decreaseStock(Long id, int amount) {
		 Optional<Product> p = prepo.findById(id);	   
		 
		 if (p.isPresent()) 
		 {
			 Product newProduct = p.get();
			 if (newProduct.getStockQuantity() < amount)
			 {
		            throw new InsufficientStockException("Insufficient stock available");
			 }
			 else
			 {
				 newProduct.setStockQuantity(newProduct.getStockQuantity() - amount);
			 }
			 return prepo.save(newProduct);
		 }
		 else
		 {
			 throw new RuntimeException("Product not found with id: " );
		 }
	    }
	

	@Override
	public List<Product> getLowStockProducts() 
	{
		
		return prepo.findByStockQuantityLessThan(100);
	}

	
 }
	
	

