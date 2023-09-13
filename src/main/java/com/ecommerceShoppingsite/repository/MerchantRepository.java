package com.ecommerceShoppingsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceShoppingsite.dto.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, String>{
	public Merchant findByEmailAndPassword(String email,String password);
}
