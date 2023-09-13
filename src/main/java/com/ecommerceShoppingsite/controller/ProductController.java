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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceShoppingsite.dto.Product;
import com.ecommerceShoppingsite.service.ProductService;
import com.ecommerceShoppingsite.util.ResponseStructure;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
@Api(value = "ProductCRUD",description = "Product details")
public class ProductController {

	@Autowired
	ProductService productService;
	@ApiOperation(value="save Product",notes="saves the product details")
	@ApiResponses(value= { @ApiResponse(code=200,message="successful"),
						   @ApiResponse(code=400,message="bad request"),
						   @ApiResponse(code=403,message="access forbidden"),
						   @ApiResponse(code=404,message="given id is not found"),
						   @ApiResponse(code=405,message="Method not allowed"),})
	@PostMapping("/save/{merchant_id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,@PathVariable String merchant_id) {
		return productService.saveProduct(product,merchant_id);
	}
	@ApiOperation(value="Get Product By ID",notes="gets product by using id")
	@ApiResponses(value= {@ApiResponse(code=200,message="successful"),
						 @ApiResponse(code=400,message="bad request"),
						 @ApiResponse(code=403,message="forbidden"),
						 @ApiResponse(code=404,message="Id not found"),
						 @ApiResponse(code=405,message="method not allowed"),})	
	@GetMapping("{id}")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable String id){
		return productService.getProductById(id);
	}
	@ApiOperation(value="Get all Product",notes="gets all products")
	@ApiResponses(value= {@ApiResponse(code=200,message="successful"),
						 @ApiResponse(code=400,message="bad request"),
						 @ApiResponse(code=403,message="forbidden"),
						 @ApiResponse(code=404,message="Id not found"),
						 @ApiResponse(code=405,message="method not allowed"),})	
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@ApiOperation(value="update Product By ID",notes="updates product by using id")
	@ApiResponses(value= {@ApiResponse(code=200,message="successful"),
						 @ApiResponse(code=400,message="bad request"),
						 @ApiResponse(code=403,message="forbidden"),
						 @ApiResponse(code=404,message="Id not found"),
						 @ApiResponse(code=405,message="method not allowed"),})	
	@PutMapping("{id}")
	public ResponseEntity<ResponseStructure<Product>> updateProductDetails(@PathVariable String id,@RequestBody Product product){
		return productService.UpdateProductDetails(id, product);
	}
	
	@ApiOperation(value="Delete Product By ID",notes="deletes product by using id")
	@ApiResponses(value= {@ApiResponse(code=200,message="successful"),
						 @ApiResponse(code=400,message="bad request"),
						 @ApiResponse(code=403,message="forbidden"),
						 @ApiResponse(code=404,message="Id not found"),
						 @ApiResponse(code=405,message="method not allowed"),})	
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteById(@PathVariable String id){
		return productService.deleteById(id);
	}
	
	@ApiOperation(value="Delete all Products",notes="deletes all product ")
	@ApiResponses(value= {@ApiResponse(code=200,message="successful"),
						 @ApiResponse(code=400,message="bad request"),
						 @ApiResponse(code=403,message="forbidden"),
						 @ApiResponse(code=404,message="Id not found"),
						 @ApiResponse(code=405,message="method not allowed"),})	
	@DeleteMapping()
	public ResponseEntity<ResponseStructure<List<Product>>> deleteAllProducts(){
		return productService.deleteAllProducts();
	}
}
