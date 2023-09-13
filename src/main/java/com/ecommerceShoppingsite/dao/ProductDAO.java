package com.ecommerceShoppingsite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerceShoppingsite.dto.Product;
import com.ecommerceShoppingsite.repository.ProductRepository;

@Repository
public class ProductDAO {

	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> getProductById(String id) {
		return productRepository.findById(id);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public void deleteById(String id) {
		productRepository.deleteById(id);
	}
	public void deleteAllProducts() {
		productRepository.deleteAll();
	}
	
}
