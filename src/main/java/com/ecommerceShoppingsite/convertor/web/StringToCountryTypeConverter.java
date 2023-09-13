package com.ecommerceShoppingsite.convertor.web;

import org.springframework.core.convert.converter.Converter;

import com.ecommerceShoppingsite.util.EnCountryType;

@RequestParameterConverter
public class StringToCountryTypeConverter implements Converter<String, EnCountryType> {

	@Override
	public EnCountryType convert(String source) {
		return EnCountryType.decode(source);
	}
}
