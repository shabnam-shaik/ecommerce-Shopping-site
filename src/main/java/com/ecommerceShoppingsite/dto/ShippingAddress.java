package com.ecommerceShoppingsite.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.ecommerceShoppingsite.util.EnCountryType;
import com.ecommerceShoppingsite.util.EnStateType;

import lombok.Data;

@Entity
@Data
public class ShippingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String house_no;
	@NotBlank
	private String streetname;
	private String city;
	private EnStateType state;
	private EnCountryType country;
	
}