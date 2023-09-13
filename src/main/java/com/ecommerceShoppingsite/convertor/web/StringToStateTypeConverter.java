package com.ecommerceShoppingsite.convertor.web;

import org.springframework.core.convert.converter.Converter;

import com.ecommerceShoppingsite.util.EnStateType;

@RequestParameterConverter
public class StringToStateTypeConverter implements Converter<String, EnStateType> {
    
	@Override
    public EnStateType convert(String source) {
        return EnStateType.decode(source);
    }
}