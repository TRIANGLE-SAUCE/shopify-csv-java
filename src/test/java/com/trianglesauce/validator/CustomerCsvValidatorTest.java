package com.trianglesauce.validator;

import com.trianglesauce.dto.CustomerCsv;
import com.trianglesauce.dto.CustomerCsvBuilder;
import com.trianglesauce.enums.MetafieldValueType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CustomerCsvValidatorTest {

	@Test
	void getInstance() {
		Assertions.assertThat(CustomerCsvValidator.getInstance())
				.isInstanceOf(CustomerCsvValidator.class);
	}

	@Nested
	class ValidateTest {

		private final CustomerCsvValidator customerCsvValidator = CustomerCsvValidator.getInstance();

		@Test
		void success() {
			CustomerCsv customerCsv = new CustomerCsvBuilder()
					.withFirstName("Taro")
					.withLastName("Tanaka")
					.withEmail("test@triangle-sauce.com")
					.withCompany("build&scrap,inc")
					.withAddress1("1-11-17 Ebisu")
					.withCity("Shibuya Ward")
					.withProvince("Tokyo")
					.withProvinceCode("13")
					.withCountry("Japan")
					.withCountryCode("JP")
					.withZip("150-0022")
					.withPhone("1234567")
					.withTags("tag1,tag2,tag3")
					.withNote("triangle-sauce")
					.withMetafieldKey("test-key")
					.withMetafieldValue("test-value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.build();
			Assertions.assertThatCode(() -> customerCsvValidator.validate(customerCsv))
					.doesNotThrowAnyException();
		}

		@Test
		void notContainsUniqueColumn() {
			CustomerCsv customerCsv = new CustomerCsvBuilder().build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("email or phone or name (last name and first name) must not be null.");
		}

		@Test
		void notContainsUniqueColumnWhenOnlyFirstNameNotNull() {
			CustomerCsv customerCsv = new CustomerCsvBuilder().withFirstName("Taro").build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("email or phone or name (last name and first name) must not be null.");
		}

		@Test
		void notContainsUniqueColumnWhenOnlyLastNameNotNull() {
			CustomerCsv customerCsv = new CustomerCsvBuilder().withLastName("Tanaka").build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("email or phone or name (last name and first name) must not be null.");
		}

		@Test
		void invalidEmail() {
			CustomerCsv customerCsv = new CustomerCsvBuilder().withEmail("test").build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("email is invalid format.");
		}

		@Test
		void provinceCodeRequired() {
			CustomerCsv customerCsv = new CustomerCsvBuilder()
					.withFirstName("Taro")
					.withLastName("Tanaka")
					.withEmail("test@triangle-sauce.com")
					.withPhone("1234567")
					.withAddress1("1-11-17 Ebisu")
					.withCity("Shibuya Ward")
					.withProvince("Tokyo")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("province code must not be null.");
		}

		@Test
		void countryCodeRequired() {
			CustomerCsv customerCsv = new CustomerCsvBuilder()
					.withFirstName("Taro")
					.withLastName("Tanaka")
					.withEmail("test@triangle-sauce.com")
					.withPhone("1234567")
					.withAddress1("1-11-17 Ebisu")
					.withCity("Shibuya Ward")
					.withProvince("Tokyo")
					.withProvinceCode("13")
					.withCountry("Japan")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("country code must not be null.");
		}

		@Test
		void invalidCountryCode() {
			CustomerCsv customerCsv = new CustomerCsvBuilder()
					.withFirstName("Taro")
					.withLastName("Tanaka")
					.withEmail("test@triangle-sauce.com")
					.withPhone("1234567")
					.withAddress1("1-11-17 Ebisu")
					.withCity("Shibuya Ward")
					.withProvince("Tokyo")
					.withProvinceCode("13")
					.withCountry("Japan")
					.withCountryCode("AAAAA")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("country code must be ISO 31466-1 Alpha2 format.");
		}

		@Test
		void tagsOverLimit() {
			String tags = IntStream.rangeClosed(0, 255)
					.boxed()
					.map(Object::toString)
					.collect(Collectors.joining());
			CustomerCsv customerCsv = new CustomerCsvBuilder()
					.withFirstName("Taro")
					.withLastName("Tanaka")
					.withEmail("test@triangle-sauce.com")
					.withPhone("1234567")
					.withAddress1("1-11-17 Ebisu")
					.withCity("Shibuya Ward")
					.withProvince("Tokyo")
					.withProvinceCode("13")
					.withCountry("Japan")
					.withCountryCode("JP")
					.withTags(tags)
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("tags must not be greater than 255.");
		}

		@Test
		void metafieldKeyOverLimit() {
			String metafieldKey = IntStream.rangeClosed(0, 30)
					.boxed()
					.map(Object::toString)
					.collect(Collectors.joining());
			CustomerCsv customerCsv = new CustomerCsvBuilder()
					.withFirstName("Taro")
					.withLastName("Tanaka")
					.withEmail("test@triangle-sauce.com")
					.withPhone("1234567")
					.withAddress1("1-11-17 Ebisu")
					.withCity("Shibuya Ward")
					.withProvince("Tokyo")
					.withProvinceCode("13")
					.withCountry("Japan")
					.withCountryCode("JP")
					.withTags("tag1,tag2,tag3")
					.withMetafieldKey(metafieldKey)
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("metafield key must not be greater than 30.");
		}

		@Test
		void metafieldValueRequired() {
			CustomerCsv customerCsv = new CustomerCsvBuilder()
					.withFirstName("Taro")
					.withLastName("Tanaka")
					.withEmail("test@triangle-sauce.com")
					.withPhone("1234567")
					.withAddress1("1-11-17 Ebisu")
					.withCity("Shibuya Ward")
					.withProvince("Tokyo")
					.withProvinceCode("13")
					.withCountry("Japan")
					.withCountryCode("JP")
					.withTags("tag1,tag2,tag3")
					.withMetafieldKey("key")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("metafield value must not be null.");
		}

		@Test
		void metafieldValueTypeRequired() {
			CustomerCsv customerCsv = new CustomerCsvBuilder()
					.withFirstName("Taro")
					.withLastName("Tanaka")
					.withEmail("test@triangle-sauce.com")
					.withPhone("1234567")
					.withAddress1("1-11-17 Ebisu")
					.withCity("Shibuya Ward")
					.withProvince("Tokyo")
					.withProvinceCode("13")
					.withCountry("Japan")
					.withCountryCode("JP")
					.withTags("tag1,tag2,tag3")
					.withMetafieldKey("key")
					.withMetafieldValue("value")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("metafield value type must not be null.");
		}

		@Test
		void metafieldNamespaceOverlimit() {
			CustomerCsv customerCsv = new CustomerCsvBuilder()
					.withFirstName("Taro")
					.withLastName("Tanaka")
					.withEmail("test@triangle-sauce.com")
					.withPhone("1234567")
					.withAddress1("1-11-17 Ebisu")
					.withCity("Shibuya Ward")
					.withProvince("Tokyo")
					.withProvinceCode("13")
					.withCountry("Japan")
					.withCountryCode("JP")
					.withTags("tag1,tag2,tag3")
					.withMetafieldKey("key")
					.withMetafieldValue("value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.withMetafieldNamespace("AAAAAAAAAAAAAAAAAAAAA")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("metafield namespace must not be greater than 20.");
		}
	}

}
