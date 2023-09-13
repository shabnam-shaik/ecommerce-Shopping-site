package com.ecommerceShoppingsite.convertor.database;

import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import com.ecommerceShoppingsite.util.EnStateType;

/**
 * AttributeConvertEnItemTypeype, String>. Implements the following methods :
 * <ul>
 * <li>convertToDatabaseColumn : (given an Enum returns a String)
 * <li>convertToEntityAttribute : (given a String returns an Enum)
 * </ul>
 */
@Component
@Converter(autoApply = true)
public class EnStateTypeConverter implements AttributeConverter<EnStateType, String> {
	@Override
	public String convertToDatabaseColumn(final EnStateType attribute) {
		return Optional.ofNullable(attribute).map(EnStateType::getstate).orElse(null);
	}

	@Override
	public EnStateType convertToEntityAttribute(final String dbData) {
		return EnStateType.decode(dbData);
	}
}

