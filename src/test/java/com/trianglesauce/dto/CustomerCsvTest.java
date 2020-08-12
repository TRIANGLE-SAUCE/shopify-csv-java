package com.trianglesauce.dto;

import com.trianglesauce.enums.AcceptsMarketing;
import com.trianglesauce.enums.MetafieldValueType;
import com.trianglesauce.enums.TaxExempt;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerCsvTest {

	@Test
	void createCustomerCsv() {
		CustomerCsv actual = CustomerCsv.CustomerCsvBuilder.builder()
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

		Assertions.assertThat(actual)
				.extracting(
						CustomerCsv::getFirstName,
						CustomerCsv::getLastName,
						CustomerCsv::getEmail,
						CustomerCsv::getCompany,
						CustomerCsv::getAddress1,
						CustomerCsv::getCity,
						CustomerCsv::getProvince,
						CustomerCsv::getProvinceCode,
						CustomerCsv::getCountry,
						CustomerCsv::getCountryCode,
						CustomerCsv::getZip,
						CustomerCsv::getPhone,
						CustomerCsv::getAcceptsMarketing,
						CustomerCsv::getTags,
						CustomerCsv::getNote,
						CustomerCsv::getTaxExempt,
						CustomerCsv::getMetafieldNamespace,
						CustomerCsv::getMetafieldKey,
						CustomerCsv::getMetafieldValue,
						CustomerCsv::getMetafieldValueType)
				.containsExactly(
						"Taro",
						"Tanaka",
						"test@triangle-sauce.com",
						"build&scrap,inc",
						"1-11-17 Ebisu",
						"Shibuya Ward",
						"Tokyo",
						"13",
						"Japan",
						"JP",
						"150-0022",
						"1234567",
						AcceptsMarketing.NO,
						"tag1,tag2,tag3",
						"triangle-sauce",
						TaxExempt.NO,
						"global",
						"test-key",
						"test-value",
						MetafieldValueType.STRING);
	}
}
