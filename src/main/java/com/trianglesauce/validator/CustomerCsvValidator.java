package com.trianglesauce.validator;

import com.trianglesauce.dto.CustomerCsv;
import com.trianglesauce.util.Assert;

public class CustomerCsvValidator implements CsvValidator<CustomerCsv> {

	private CustomerCsvValidator() {}

	public static CustomerCsvValidator getInstance() {
		return new CustomerCsvValidator();
	}

	@Override
	public void validate(CustomerCsv customerCsv) {
		// unique keys
		validateUniqueKeys(customerCsv);

		// province
		if (customerCsv.getProvince() != null) {
			Assert.notNull(customerCsv.getProvinceCode(), "province code must not be null.");
		}

		// country code
		Assert.notNull(customerCsv.getCountryCode(), "country code must not be null.");
		if (!ALPHA2_COUNTRY_CODES.contains(customerCsv.getCountryCode())) {
			throw new IllegalArgumentException("country code must be ISO 31466-1 Alpha2 format.");
		}

		// tags
		if (hasText(customerCsv.getTags()) && customerCsv.getTags().length() > getTagsLength()) {
			throw new IllegalArgumentException("tags must not be greater than " + getTagsLength() + ".");
		}
	}

	private void validateUniqueKeys(CustomerCsv customerCsv) {
		if (customerCsv.getEmail() == null &&
				customerCsv.getPhone() == null &&
				(customerCsv.getFirstName() == null || customerCsv.getLastName() == null)) {
			throw new IllegalArgumentException("email or phone or name (last name and first name) must not be null.");
		}

		validateEmail(customerCsv.getEmail(), "email is invalid format.");
	}
}
