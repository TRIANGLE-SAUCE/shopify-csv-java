package com.trianglesauce.validator;

import com.trianglesauce.dto.Csv;

public interface CsvValidator<T extends Csv> {

	default boolean hasText(String value) {
		if (value == null) {
			return false;
		}
		return !value.isBlank();
	}

	void validate(T csv);
}
