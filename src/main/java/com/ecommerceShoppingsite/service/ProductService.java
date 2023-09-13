package com.ecommerceShoppingsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerceShoppingsite.dao.MerchantDAO;
import com.ecommerceShoppingsite.dao.ProductDAO;
import com.ecommerceShoppingsite.dto.Merchant;
import com.ecommerceShoppingsite.dto.Product;
import com.ecommerceShoppingsite.exception.IdNotFoundException;
import com.ecommerceShoppingsite.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	MerchantDAO merchantDAO;
	
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product,String merchant_id){
		Optional<Merchant> opt=merchantDAO.getMerchant(merchant_id);
		
		if(opt.isPresent()) {
			ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
			Product product1=productDAO.saveProduct(product);
			Merchant merchant=opt.get();
			product1.setMerchant(merchant);
			
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("created successfully");
			responseStructure.setData(productDAO.saveProduct(product1));
			
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);
		}else {
			throw new IdNotFoundException("invalid id "+merchant_id+" enter a valid id");
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> getProductById(String id){
		Optional<Product> opt=productDAO.getProductById(id);
		
		if(opt.isPresent()) {
			ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
			
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("product details got successfully");
			responseStructure.setData(opt.get());
			
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFoundException(id);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(){
		ResponseStructure<List<Product>> responseStructure=new ResponseStructure<>();
		
		responseStructure.setStatus(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Got all product Details");
		responseStructure.setData(productDAO.getAllProducts());
		
		return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Product>> UpdateProductDetails(String id,Product product){
		Optional<Product> opt=productDAO.getProductById(id);
		
		if(opt.isPresent()) {
			Product product1=opt.get();
			
			product1.setName(product.getName());
			product1.setCategory(product.getCategory());
			product1.setDescription(product.getDescription());
			product1.setManufacturer(product.getDescription());
			product1.setPrice(product.getPrice());
			
			ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
			
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("updated successfully");
			responseStructure.setData(productDAO.saveProduct(product1));
			
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFoundException(id);
		}
	}
	public ResponseEntity<ResponseStructure<Product>> deleteById(String id){
		Optional<Product> opt=productDAO.getProductById(id);
		
		if(opt.isPresent()) {
			productDAO.deleteById(id);
			ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted successfully");
			
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException(id);
		}
	}
	public ResponseEntity<ResponseStructure<List<Product>>> deleteAllProducts(){
		ResponseStructure<List<Product>> responseStructure=new ResponseStructure<List<Product>>();
		productDAO.deleteAllProducts();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted successfully");
		
		return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,HttpStatus.OK);
	}
}
