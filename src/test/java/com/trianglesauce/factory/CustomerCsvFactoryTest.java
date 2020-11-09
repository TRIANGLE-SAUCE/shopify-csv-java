package com.trianglesauce.factory;

import com.trianglesauce.dto.CustomerCsv;
import com.trianglesauce.dto.CustomerCsvBuilder;
import com.trianglesauce.enums.MetafieldValueType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class CustomerCsvFactoryTest {

	private final CsvFactory<CustomerCsv> factory = new CustomerCsvFactory();

	@Test
	void createCsv() throws Exception {
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
		Assertions.assertThat(factory.create(Collections.singletonList(customerCsv)))
				.isEqualTo(
						"\"First Name\",\"Last Name\",Email,Company,Address1,Address2,City,Province,\"Province Code\",Country,\"Country Code\",Zip,Phone,\"Accepts Marketing\",Tags,Note,\"Tax Exempt\",\"Metafield Namespace\",\"Metafield Key\",\"Metafield Value\",\"Metafield Value Type\"\n" +
								"Taro,Tanaka,test@triangle-sauce.com,\"build&scrap,inc\",\"1-11-17 Ebisu\",,\"Shibuya Ward\",Tokyo,13,Japan,JP,150-0022,1234567,no,\"tag1,tag2,tag3\",triangle-sauce,no,global,test-key,test-value,string\n");
	}

}
