package com.ecommerceShoppingsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerceShoppingsite.dao.AdminDAO;
import com.ecommerceShoppingsite.dto.Admin;
import com.ecommerceShoppingsite.exception.IdNotFoundException;
import com.ecommerceShoppingsite.util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	AdminDAO adminDAO;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Admin saved successfully");
		responseStructure.setData(adminDAO.saveAdmin(admin));

		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(String id){
		Optional<Admin> opt=adminDAO.getAdminById(id);
		
		if(opt.isPresent()) {
			ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
			
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Admin details got successfully");
			responseStructure.setData(opt.get());
			
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Given ID "+id+" is not found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmins(){
		
		ResponseStructure<List<Admin>> responseStructure=new ResponseStructure<List<Admin>>();
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("All Admin details found succesfully");
		responseStructure.setData(adminDAO.getAllAdmins());
		
		return new ResponseEntity<ResponseStructure<List<Admin>>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(String id,Admin admin){
		Optional<Admin> opt=adminDAO.getAdminById(id);
		
		if(opt.isPresent()) {
			Admin admin1=opt.get();
			
			admin1.setName(admin.getName());
			admin1.setEmail(admin.getEmail());
			admin1.setPassword(admin.getPassword());
			admin1.setPhone_no(admin.getPhone_no());
			
			ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Updated successfully");
			responseStructure.setData(adminDAO.saveAdmin(admin1));
			
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFoundException("given id "+id+" doesnt exist");
		}
	}
	public ResponseEntity<ResponseStructure<Admin>> deleteById(String id){
		Optional<Admin> opt=adminDAO.getAdminById(id);
		
		if(opt.isPresent()) {
			adminDAO.deleteAdmin(id);
			
			ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
			
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted successfully");
			
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
}
