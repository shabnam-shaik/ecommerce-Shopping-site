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

import com.ecommerceShoppingsite.dto.Merchant;
import com.ecommerceShoppingsite.dto.Product;
import com.ecommerceShoppingsite.service.MerchantService;
import com.ecommerceShoppingsite.util.ResponseStructure;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/merchant")
@Api(value="MerchantCRUD", description = "merchant details")
public class MerchantController {

	@Autowired
	MerchantService merchantService;

	@ApiOperation(value="save Merchant",notes="saves the merchant details")
	@ApiResponses(value= { @ApiResponse(code=200,message="successful"),
						   @ApiResponse(code=400,message="bad request"),
						   @ApiResponse(code=403,message="access forbidden"),
						   @ApiResponse(code=404,message="given id is not found"),
						   @ApiResponse(code=405,message="Method not allowed"),})
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant) {
		return merchantService.saveMerchant(merchant);
	}
	
	@ApiOperation(value="get merchant details by using id",notes="get merchant details by id")
	@ApiResponses(value= { @ApiResponse(code=200,message="successful"),
						   @ApiResponse(code=400,message="bad request"),
						   @ApiResponse(code=403,message="access forbidden"),
						   @ApiResponse(code=404,message="given id is not found"),
						   @ApiResponse(code=405,message="Method not allowed"),})
	@GetMapping("{id}")
	public ResponseEntity<ResponseStructure<Merchant>> getMerchantById(@PathVariable String id){
		return merchantService.getMerchantById(id);
	}
	
	@ApiOperation(value="get all merchants",notes="get all merchants details")
	@ApiResponses(value= { @ApiResponse(code=200,message="successful"),
						   @ApiResponse(code=400,message="bad request"),
						   @ApiResponse(code=403,message="access forbidden"),
						   @ApiResponse(code=404,message="given id is not found"),
						   @ApiResponse(code=405,message="Method not allowed"),})
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Merchant>>> getAllMerchants(){
		return merchantService.getAllMerchants();
	}
	
	@ApiOperation(value="update merchant details",notes="update merchant details")
	@ApiResponses(value= { @ApiResponse(code=200,message="successful"),
						   @ApiResponse(code=400,message="bad request"),
						   @ApiResponse(code=403,message="access forbidden"),
						   @ApiResponse(code=404,message="given id is not found"),
						   @ApiResponse(code=405,message="Method not allowed"),})
	@PutMapping("{id}")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchantById(@PathVariable String id, @RequestBody Merchant merchant){
		return merchantService.updateMerchantById(id, merchant);
	}
	
	@ApiOperation(value="delete merchant",notes="delete merchant details")
	@ApiResponses(value= { @ApiResponse(code=200,message="successful"),
						   @ApiResponse(code=400,message="bad request"),
						   @ApiResponse(code=403,message="access forbidden"),
						   @ApiResponse(code=404,message="given id is not found"),
						   @ApiResponse(code=405,message="Method not allowed"),})
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Merchant>> deleteMerchantById(@PathVariable String id){
		return merchantService.deleteMerchantById(id);
	}
	
	
}
