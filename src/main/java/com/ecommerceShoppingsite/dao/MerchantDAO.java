package com.ecommerceShoppingsite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerceShoppingsite.dto.Merchant;
import com.ecommerceShoppingsite.dto.Product;
import com.ecommerceShoppingsite.repository.MerchantRepository;
import com.ecommerceShoppingsite.repository.ProductRepository;

@Repository
public class MerchantDAO {

	@Autowired
	MerchantRepository merchantRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public Merchant saveMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}
	
	public Optional<Merchant> getMerchant(String id) {
		return merchantRepository.findById(id);
	}
	
	public List<Merchant> getAllMerchants(){
		return merchantRepository.findAll();
	}
	
	public void deleteMerchantById(String id) {
		merchantRepository.deleteById(id);
	}
	
	
}
