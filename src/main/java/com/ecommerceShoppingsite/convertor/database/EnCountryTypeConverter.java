package com.ecommerceShoppingsite.convertor.database;

import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import com.ecommerceShoppingsite.util.EnCountryType;

/**
 * AttributeConvertEnItemTypeype, String>. Implements the following methods :
 * <ul>
 * <li>convertToDatabaseColumn : (given an Enum returns a String)
 * <li>convertToEntityAttribute : (given a String returns an Enum)
 * </ul>
 */
@Component
@Converter(autoApply = true)
public class EnCountryTypeConverter implements AttributeConverter<EnCountryType, String> {
	@Override
	public String convertToDatabaseColumn(final EnCountryType attribute) {
		return Optional.ofNullable(attribute).map(EnCountryType::getCountry).orElse(null);
	}

	@Override
	public EnCountryType convertToEntityAttribute(final String dbData) {
		return EnCountryType.decode(dbData);
	}
}
