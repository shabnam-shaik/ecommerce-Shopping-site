package com.ecommerceShoppingsite.dto;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
//import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ecommerceShoppingsite.util.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Merchant {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_seq")
	@GenericGenerator(name = "merchant_seq", strategy = "com.ecommerceShoppingsite.util.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Merchant_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d") })
	private String id;
	private String name;
	private String email;
	private String password;
	private String phone_no;
	private long aadharNumber;
	private String gst;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "merchant")
	@Cascade(value = CascadeType.ALL)
	private List<Product> product;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private BillingAddress billingAddress;
	
}
