package com.trianglesauce.validator;

import com.trianglesauce.dto.Csv;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.*;

public interface CsvValidator<T extends Csv> {

	EmailValidator EMAIL_VALIDATOR = EmailValidator.getInstance();
	Set<String> ALPHA2_COUNTRY_CODES = Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA2);

	default boolean hasText(String value) {
		if (value == null) {
			return false;
		}
		return !value.isBlank();
	}

	void validate(T csv);
}
