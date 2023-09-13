package com.ecommerceShoppingsite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerceShoppingsite.dto.Admin;
import com.ecommerceShoppingsite.repository.AdminRepository;

@Repository
public class AdminDAO {

	@Autowired
	AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	public Optional<Admin> getAdminById(String id) {
		return adminRepository.findById(id);
	}
	public List<Admin> getAllAdmins(){
		return adminRepository.findAll();
	}
	public void deleteAdmin(String id) {
		adminRepository.deleteById(id);
	}
}
