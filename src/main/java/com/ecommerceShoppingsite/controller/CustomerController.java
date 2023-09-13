package com.ecommerceShoppingsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceShoppingsite.dto.Customer;
import com.ecommerceShoppingsite.service.CustomerService;
import com.ecommerceShoppingsite.util.ResponseStructure;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
@Api(value="CustomerCRUD",description = "Customer details")
class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@ApiOperation(value="save customer",notes="save customer details")
	@ApiResponses(value= { @ApiResponse(code=200,message="successful"),
						   @ApiResponse(code=400,message="bad request"),
						   @ApiResponse(code=403,message="access forbidden"),
						   @ApiResponse(code=404,message="given id is not found"),
						   @ApiResponse(code=405,message="Method not allowed"),})
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer){
		return customerService.saveCustomer(customer);
	}
	
	@ApiOperation(value="get customer by id",notes="get customer details")
	@ApiResponses(value= { @ApiResponse(code=200,message="successful"),
						   @ApiResponse(code=400,message="bad request"),
						   @ApiResponse(code=403,message="access forbidden"),
						   @ApiResponse(code=404,message="given id is not found"),
						   @ApiResponse(code=405,message="Method not allowed"),})
	@GetMapping("{id}")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@PathVariable String id){
		return customerService.getCustomerById(id);
	}
	
	@ApiOperation(value="get all customers",notes="get all customers details")
	@ApiResponses(value= { @ApiResponse(code=200,message="successful"),
						   @ApiResponse(code=400,message="bad request"),
						   @ApiResponse(code=403,message="access forbidden"),
						   @ApiResponse(code=404,message="given id is not found"),
						   @ApiResponse(code=405,message="Method not allowed"),})
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@ApiOperation(value="update customer",notes="update customer details")
	@ApiResponses(value= { @ApiResponse(code=200,message="successful"),
						   @ApiResponse(code=400,message="bad request"),
						   @ApiResponse(code=403,message="access forbidden"),
						   @ApiResponse(code=404,message="given id is not found"),
						   @ApiResponse(code=405,message="Method not allowed"),})
	@PutMapping("{id}")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@PathVariable String id,@RequestBody Customer customer){
		return customerService.updateCustomer(id, customer);
	}
		
	@ApiOperation(value="delete customer by id",notes="delete customer details")
	@ApiResponses(value= { @ApiResponse(code=200,message="successful"),
						   @ApiResponse(code=400,message="bad request"),
						   @ApiResponse(code=403,message="access forbidden"),
						   @ApiResponse(code=404,message="given id is not found"),
						   @ApiResponse(code=405,message="Method not allowed"),})
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@PathVariable String id){
		return customerService.deleteCustomer(id);
	}
}
