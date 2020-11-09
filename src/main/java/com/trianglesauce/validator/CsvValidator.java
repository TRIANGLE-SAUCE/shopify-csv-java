package com.trianglesauce.validator;

import com.trianglesauce.dto.Csv;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.*;

public interface CsvValidator<T extends Csv> {

	EmailValidator EMAIL_VALIDATOR = EmailValidator.getInstance();
	Set<String> ALPHA2_COUNTRY_CODES = Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA2);

	default int getTagsLength() {
		return 255;
	}

	default int getMetafieldNamespaceLength() {
		return 20;
	}

	default int getMetafieldKeyLength() {
		return 30;
	}

	default boolean hasText(String value) {
		if (value == null) {
			return false;
		}
		return !value.isBlank();
	}

	default void validateEmail(String email, String message) {
		if (hasText(email) && !EMAIL_VALIDATOR.isValid(email)) {
			throw new IllegalArgumentException(message);
		}
	}

	default void validateTags(String tags) {
		if (hasText(tags) && tags.length() > getTagsLength()) {
			throw new IllegalArgumentException("tags must not be greater than " + getTagsLength() + ".");
		}
	}

	void validate(T csv);
}
