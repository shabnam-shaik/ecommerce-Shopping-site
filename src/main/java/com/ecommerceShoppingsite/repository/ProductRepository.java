package com.ecommerceShoppingsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceShoppingsite.dto.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
	
}
