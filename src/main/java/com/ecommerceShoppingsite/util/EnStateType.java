package com.ecommerceShoppingsite.util;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EnStateType {
	
	TYPE1("Karnataka"),
	TYPE2("Andhra Pradesh"),
	TYPE3("Telangana"),
	TYPE4("TamilNadu"),
	TYPE5("Kerala");

	private String state ;
	
	private EnStateType(String state) {
		this.state=state;
	}
	
	@JsonCreator
	public static EnStateType decode(final String state) {
	return	Stream.of(EnStateType.values()).filter(targetEnum->targetEnum.state.equals(state)).findFirst().orElse(null);
	}
	
	@JsonValue
	public String getstate() {
		return state;
	}
}
