package com.ecommerceShoppingsite.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ecommerceShoppingsite.util.StringPrefixedSequenceIdGenerator;

import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq")
	@GenericGenerator(name = "admin_seq", strategy = "com.ecommerceShoppingsite.util.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ADMIN_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d") })
	private String id;
//	@NotEmpty(message = "Name may not be empty")
//	@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") 
	private String name;
//	@NotBlank
	private String email;
	//@NotBlank
	private String password;
	
	private long phone_no;

}
