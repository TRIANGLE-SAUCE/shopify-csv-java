package com.trianglesauce.validator;

import com.trianglesauce.dto.CustomerDto;
import com.trianglesauce.util.Assert;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Locale;
import java.util.Set;

public class CustomerDtoValidator implements DtoValidator {

	public static final EmailValidator EMAIL_VALIDATOR = EmailValidator.getInstance();
	public static final Set<String> ALPHA2_COUNTRY_CODES =
			Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA2);

	private CustomerDtoValidator() {}

	public static CustomerDtoValidator getInstance() {
		return new CustomerDtoValidator();
	}

	public void validate(CustomerDto dto) {
		// name
		if (dto.getEmail() == null && dto.getPhone() == null) {
			Assert.notNull(dto.getFirstName(), "first name must not be null.");
			Assert.notNull(dto.getLastName(), "last name must not be null.");
		}

		// email
		if (dto.getPhone() == null || (dto.getFirstName() == null && dto.getLastName() == null)) {
			Assert.notNull(dto.getEmail(), "email must not be null.");
		}
		if (!EMAIL_VALIDATOR.isValid(dto.getEmail())) {
			throw new IllegalArgumentException("email is invalid format.");
		}

		// address1
		Assert.notNull(dto.getAddress1(), "address1 must not be null.");

		// city
		Assert.notNull(dto.getCity(), "city must not be null.");

		// country
		Assert.notNull(dto.getCountry(), "country must not be null.");

		// country code
		Assert.notNull(dto.getCountryCode(), "country code must not be null.");
		if (!ALPHA2_COUNTRY_CODES.contains(dto.getCountryCode())) {
			throw new IllegalArgumentException("country code must be ISO 31466-1 Alpha2 format.");
		}

		// tags
		if (hasText(dto.getTags())) {
			if (dto.getTags().length() > 255) {
				throw new IllegalArgumentException("tags must not be greater than 255.");
			}
		}

		// province
		if (dto.getProvince() != null) {
			Assert.notNull(dto.getProvinceCode(), "province code must not be null.");
		}

		// phone
		if (dto.getEmail() == null || (dto.getFirstName() == null && dto.getLastName() == null)) {
			Assert.notNull(dto.getPhone(), "phone must not be null");
		}

		// metafield
		validateMetafield(dto);
	}

	private void validateMetafield(CustomerDto dto) {
		if (dto.getMetafieldKey() != null ||
				dto.getMetafieldValue() != null ||
				dto.getMetafieldValueType() != null) {
			Assert.notNull(dto.getMetafieldKey(), "metafield key must not be null");
			if (dto.getMetafieldKey().length() > 30) {
				throw new IllegalArgumentException("metafield key must not be greater than 30.");
			}

			Assert.notNull(dto.getMetafieldValue(), "metafield valu must not be null");
			Assert.notNull(dto.getMetafieldValueType(), "metafield value type must not be null");

			Assert.notNull(dto.getMetafieldNamespace(), "metafield namespace must not be null");
			if (dto.getMetafieldNamespace().length() > 20) {
				throw new IllegalArgumentException("metafield namespace must not be greater than 20.");
			}
		}
	}
}
