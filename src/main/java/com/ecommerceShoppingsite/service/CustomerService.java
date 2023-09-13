package com.ecommerceShoppingsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerceShoppingsite.dao.CustomerDAO;
import com.ecommerceShoppingsite.dto.Customer;
import com.ecommerceShoppingsite.exception.IdNotFoundException;
import com.ecommerceShoppingsite.util.ResponseStructure;

@Service
public class CustomerService {
	@Autowired
	CustomerDAO customerDAO;
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer){
		ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved successfully");
		responseStructure.setData(customerDAO.saveCustomer(customer));
		
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(String id){
		Optional<Customer> opt=customerDAO.getCustomerById(id);
		
		if(opt.isPresent()) {
			ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
			
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("got customer details by using id");
			responseStructure.setData(opt.get());
			
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers(){
		ResponseStructure<List<Customer>> responseStructure=new ResponseStructure<List<Customer>>();
		
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("got all the Customers");
		responseStructure.setData(customerDAO.getAllCustomers());
		
		return new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(String id,Customer customer){
		Optional<Customer> opt=customerDAO.getCustomerById(id);
		
		if(opt.isPresent()) {
			Customer customer1=opt.get();
			ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
			
			customer1.setName(customer.getName());
			customer1.setEmail(customer.getEmail());
			customer1.setPassword(customer.getPassword());
			customer1.setPhone_no(customer.getPhone_no());
			customer1.setShippingAddress(customer.getShippingAddress());
			
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Updated successfully");
			responseStructure.setData(customerDAO.saveCustomer(customer1));
			
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(String id){
		Optional<Customer> opt= customerDAO.getCustomerById(id);
		if(opt.isPresent() ) {
			ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
			customerDAO.deleteCustomer(id);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("deleted succesfully");
			
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}
}
