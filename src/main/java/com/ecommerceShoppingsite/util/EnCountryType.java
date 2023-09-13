package com.ecommerceShoppingsite.util;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EnCountryType {
	TYPE1("India"),
	TYPE2("China");

	private String country;
	
	private EnCountryType(String country) {
		this.country=country;
	}
	
	@JsonCreator
	public static EnCountryType decode(final String country) {
	return	Stream.of(EnCountryType.values()).filter(targetEnum->targetEnum.country.equals(country)).findFirst().orElse(null);
	}
	
	@JsonValue
	public String getCountry() {
		return country;
	}
}
