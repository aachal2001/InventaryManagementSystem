package com.inventarymanagement.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inventarymanagement.entity.Product;
import com.inventarymanagement.service.ProductService;

import CustomException.InsufficientStockException;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/get")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @PostMapping("/register")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.register(product));
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product)
    {
    	if((product.getStockQuantity())<0)
    	{
       	 throw new RuntimeException("Product quantity should not br less than 0: " + product.getId());
    	}
        return ResponseEntity.ok(productService.updateProductById(id,product));
    }
    
    @PostMapping("/{id}/increase")
    public Product increaseStock(@PathVariable Long id, @RequestParam int amount) {
        return productService.increaseStock(id, amount);
    }
    
    @PostMapping("/{id}/decrease")
    public ResponseEntity<?> decreaseStock(@PathVariable Long id, @RequestParam int amount) {
        try {
            return ResponseEntity.ok(productService.decreaseStock(id, amount));
        } catch (InsufficientStockException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
    
    @CrossOrigin
    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    	productService.deleteProductById(id);
    	return ResponseEntity.noContent().build();
    	}
    
    @GetMapping("/products/lowstock")
    public List<Product> lowStock() {
        return productService.getLowStockProducts();
    }
    
}
