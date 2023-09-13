package com.ecommerceShoppingsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceShoppingsite.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}
