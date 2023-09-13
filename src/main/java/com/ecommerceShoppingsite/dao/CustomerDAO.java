package com.ecommerceShoppingsite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerceShoppingsite.dto.Customer;
import com.ecommerceShoppingsite.repository.CustomerRepository;

@Repository
public class CustomerDAO {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> getCustomerById(String id) {
		return customerRepository.findById(id);
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	public void deleteCustomer(String id) {
		customerRepository.deleteById(id);
	}
}
