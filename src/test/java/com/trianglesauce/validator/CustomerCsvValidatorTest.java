package com.trianglesauce.validator;

import com.trianglesauce.dto.CustomerCsv;
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
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.company("build&scrap,inc")
					.address1("1-11-17 Ebisu")
					.city("Shibuya Ward")
					.province("Tokyo")
					.provinceCode("13")
					.country("Japan")
					.countryCode("JP")
					.zip("150-0022")
					.phone("1234567")
					.tags("tag1,tag2,tag3")
					.note("triangle-sauce")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
					.build();
			Assertions.assertThatCode(() -> customerCsvValidator.validate(customerCsv))
					.doesNotThrowAnyException();
		}

		@Test
		void notContainsUniqueColumn() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder().build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("email or phone or name (last name and first name) must not be null.");
		}

		@Test
		void notContainsUniqueColumnWhenOnlyFirstNameNotNull() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder().firstName("Taro").build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("email or phone or name (last name and first name) must not be null.");
		}

		@Test
		void notContainsUniqueColumnWhenOnlyLastNameNotNull() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder().lastName("Tanaka").build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("email or phone or name (last name and first name) must not be null.");
		}

		@Test
		void invalidEmail() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder().email("test").build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("email is invalid format.");
		}

		@Test
		void address1Required() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.phone("1234567")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("address1 must not be null.");
		}

		@Test
		void cityRequired() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.phone("1234567")
					.address1("1-11-17 Ebisu")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("city must not be null.");
		}

		@Test
		void provinceCodeRequired() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.phone("1234567")
					.address1("1-11-17 Ebisu")
					.city("Shibuya Ward")
					.province("Tokyo")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("province code must not be null.");
		}

		@Test
		void countryRequired() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.phone("1234567")
					.address1("1-11-17 Ebisu")
					.city("Shibuya Ward")
					.province("Tokyo")
					.provinceCode("13")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("country must not be null.");
		}

		@Test
		void countryCodeRequired() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.phone("1234567")
					.address1("1-11-17 Ebisu")
					.city("Shibuya Ward")
					.province("Tokyo")
					.provinceCode("13")
					.country("Japan")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("country code must not be null.");
		}

		@Test
		void invalidCountryCode() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.phone("1234567")
					.address1("1-11-17 Ebisu")
					.city("Shibuya Ward")
					.province("Tokyo")
					.provinceCode("13")
					.country("Japan")
					.countryCode("AAAAA")
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
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.phone("1234567")
					.address1("1-11-17 Ebisu")
					.city("Shibuya Ward")
					.province("Tokyo")
					.provinceCode("13")
					.country("Japan")
					.countryCode("JP")
					.tags(tags)
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
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.phone("1234567")
					.address1("1-11-17 Ebisu")
					.city("Shibuya Ward")
					.province("Tokyo")
					.provinceCode("13")
					.country("Japan")
					.countryCode("JP")
					.tags("tag1,tag2,tag3")
					.metafieldKey(metafieldKey)
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("metafield key must not be greater than 30.");
		}

		@Test
		void metafieldValueRequired() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.phone("1234567")
					.address1("1-11-17 Ebisu")
					.city("Shibuya Ward")
					.province("Tokyo")
					.provinceCode("13")
					.country("Japan")
					.countryCode("JP")
					.tags("tag1,tag2,tag3")
					.metafieldKey("key")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("metafield value must not be null.");
		}

		@Test
		void metafieldValueTypeRequired() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.phone("1234567")
					.address1("1-11-17 Ebisu")
					.city("Shibuya Ward")
					.province("Tokyo")
					.provinceCode("13")
					.country("Japan")
					.countryCode("JP")
					.tags("tag1,tag2,tag3")
					.metafieldKey("key")
					.metafieldValue("value")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("metafield value type must not be null.");
		}

		@Test
		void metafieldNamespaceOverlimit() {
			CustomerCsv customerCsv = CustomerCsv.CustomerCsvBuilder.builder()
					.firstName("Taro")
					.lastName("Tanaka")
					.email("test@triangle-sauce.com")
					.phone("1234567")
					.address1("1-11-17 Ebisu")
					.city("Shibuya Ward")
					.province("Tokyo")
					.provinceCode("13")
					.country("Japan")
					.countryCode("JP")
					.tags("tag1,tag2,tag3")
					.metafieldKey("key")
					.metafieldValue("value")
					.metafieldValueType(MetafieldValueType.STRING)
					.metafieldNamespace("AAAAAAAAAAAAAAAAAAAAA")
					.build();
			Assertions.assertThatThrownBy(() -> customerCsvValidator.validate(customerCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("metafield namespace must not be greater than 20.");
		}
	}

}
