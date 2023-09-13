package com.ecommerceShoppingsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerceShoppingsite.dao.MerchantDAO;
import com.ecommerceShoppingsite.dto.Merchant;
import com.ecommerceShoppingsite.dto.Product;
import com.ecommerceShoppingsite.exception.IdNotFoundException;
import com.ecommerceShoppingsite.util.ResponseStructure;

@Service
public class MerchantService {
	
	@Autowired
	MerchantDAO merchantDAO;
	
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant merchant){
		ResponseStructure<Merchant> responseStructure=new ResponseStructure<Merchant>();
		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Merchant details saved successfully");
		responseStructure.setData(merchantDAO.saveMerchant(merchant));
		
		return new ResponseEntity<ResponseStructure<Merchant>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> getMerchantById(String id){
		Optional<Merchant> opt=merchantDAO.getMerchant(id);
		
		if(opt.isPresent()) {
			ResponseStructure<Merchant> responseStructure=new ResponseStructure<Merchant>();
			
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Got merchant details by id");
			responseStructure.setData(opt.get());
			
			return new ResponseEntity<ResponseStructure<Merchant>>(responseStructure,HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Merchant>>> getAllMerchants(){
		ResponseStructure<List<Merchant>> responseStructure=new ResponseStructure<List<Merchant>>();
		
		responseStructure.setStatus(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Got all merchant list");
		responseStructure.setData(merchantDAO.getAllMerchants());
		
		return new ResponseEntity<ResponseStructure<List<Merchant>>>(responseStructure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchantById(String id,Merchant merchant){
		Optional<Merchant> opt=merchantDAO.getMerchant(id);
		
		if(opt.isPresent()) {
			Merchant merchant1=opt.get();
			
			merchant1.setName(merchant.getName());
			merchant1.setEmail(merchant.getEmail());
			merchant1.setPassword(merchant.getPassword());
			merchant1.setPhone_no(merchant.getPhone_no());
			merchant1.setAadharNumber(merchant.getAadharNumber());
			merchant1.setGst(merchant.getGst());
			
			ResponseStructure<Merchant> responseStructure=new ResponseStructure<Merchant>();
			
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Updated successfully");
			responseStructure.setData(merchantDAO.saveMerchant(merchant1));
			
			return new ResponseEntity<ResponseStructure<Merchant>>(responseStructure,HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> deleteMerchantById(String id){
		Optional<Merchant> opt=merchantDAO.getMerchant(id);
		
		if(opt.isPresent()) {
			ResponseStructure<Merchant> responseStructure=new ResponseStructure<Merchant>();
			merchantDAO.deleteMerchantById(id);
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("deleted successfully");
			
			return new ResponseEntity<ResponseStructure<Merchant>>(responseStructure,HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFoundException("id :"+id+" doesnt exist please try again");
		}
	
	}
}
