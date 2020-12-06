package com.trianglesauce.dto;

import com.trianglesauce.enums.AcceptsMarketing;
import com.trianglesauce.enums.TaxExempt;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerCsvTest {

	@Test
	void createCustomerCsv() {
		CustomerCsv actual = new CustomerCsvBuilder()
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
						CustomerCsv::getTaxExempt)
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
						TaxExempt.NO);
	}
}
