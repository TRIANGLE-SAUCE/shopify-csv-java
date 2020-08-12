package com.trianglesauce.validator;

import com.trianglesauce.dto.CustomerCsv;
import com.trianglesauce.util.Assert;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Locale;
import java.util.Set;

public class CustomerCsvValidator implements DtoValidator {

	private static final EmailValidator EMAIL_VALIDATOR = EmailValidator.getInstance();
	private static final Set<String> ALPHA2_COUNTRY_CODES =
			Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA2);

	private static final int TAGS_LENGTH = 255;
	private static final int METAFIELD_NAMESPACE_LENGTH = 20;
	private static final int METAFIELD_KEY_LENGTH = 30;

	private CustomerCsvValidator() {}

	public static CustomerCsvValidator getInstance() {
		return new CustomerCsvValidator();
	}

	public void validate(CustomerCsv customerCsv) {
		// unique keys
		validateUniqueKeys(customerCsv);

		// address1
		Assert.notNull(customerCsv.getAddress1(), "address1 must not be null.");

		// city
		Assert.notNull(customerCsv.getCity(), "city must not be null.");

		// province
		if (customerCsv.getProvince() != null) {
			Assert.notNull(customerCsv.getProvinceCode(), "province code must not be null.");
		}

		// country
		Assert.notNull(customerCsv.getCountry(), "country must not be null.");

		// country code
		Assert.notNull(customerCsv.getCountryCode(), "country code must not be null.");
		if (!ALPHA2_COUNTRY_CODES.contains(customerCsv.getCountryCode())) {
			throw new IllegalArgumentException("country code must be ISO 31466-1 Alpha2 format.");
		}

		// tags
		if (hasText(customerCsv.getTags()) && customerCsv.getTags().length() > TAGS_LENGTH) {
			throw new IllegalArgumentException("tags must not be greater than " + TAGS_LENGTH + ".");
		}

		// metafield
		validateMetafield(customerCsv);
	}

	private void validateUniqueKeys(CustomerCsv customerCsv) {
		if (customerCsv.getEmail() == null &&
				customerCsv.getPhone() == null &&
				(customerCsv.getFirstName() == null || customerCsv.getLastName() == null)) {
			throw new IllegalArgumentException("email or phone or name (last name and first name) must not be null.");
		}

		if (hasText(customerCsv.getEmail()) && !EMAIL_VALIDATOR.isValid(customerCsv.getEmail())) {
			throw new IllegalArgumentException("email is invalid format.");
		}
	}

	private void validateMetafield(CustomerCsv customerCsv) {
		if (customerCsv.hasMetafield()) {
			Assert.notNull(customerCsv.getMetafieldKey(), "metafield key must not be null");
			if (customerCsv.getMetafieldKey().length() > METAFIELD_KEY_LENGTH) {
				throw new IllegalArgumentException("metafield key must not be greater than " + METAFIELD_KEY_LENGTH + ".");
			}

			Assert.notNull(customerCsv.getMetafieldValue(), "metafield value must not be null.");
			Assert.notNull(customerCsv.getMetafieldValueType(), "metafield value type must not be null.");

			Assert.notNull(customerCsv.getMetafieldNamespace(), "metafield namespace must not be null");
			if (customerCsv.getMetafieldNamespace().length() > METAFIELD_NAMESPACE_LENGTH) {
				throw new IllegalArgumentException("metafield namespace must not be greater than " + METAFIELD_NAMESPACE_LENGTH + ".");
			}
		}
	}
}
