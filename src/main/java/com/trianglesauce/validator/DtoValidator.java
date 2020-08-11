package com.trianglesauce.validator;

public interface DtoValidator {

	default boolean hasText(String value) {
		if (value == null) {
			return false;
		}
		return !value.isBlank();
	}
}
