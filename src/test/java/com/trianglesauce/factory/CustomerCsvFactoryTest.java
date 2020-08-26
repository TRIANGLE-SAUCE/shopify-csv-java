package com.trianglesauce.factory;

import com.trianglesauce.dto.CustomerCsv;
import com.trianglesauce.enums.MetafieldValueType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class CustomerCsvFactoryTest {

	private final CsvFactory<CustomerCsv> factory = new CustomerCsvFactory();

	@Test
	void createCsv() throws Exception {
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
		Assertions.assertThat(factory.create(Collections.singletonList(customerCsv)))
				.isEqualTo(
						"\"First Name\",\"Last Name\",Email,Company,Address1,Address2,City,Province,\"Province Code\",Country,\"Country Code\",Zip,Phone,\"Accepts Marketing\",Tags,Note,\"Tax Exempt\",\"Metafield Namespace\",\"Metafield Key\",\"Metafield Value\",\"Metafield Value Type\"\n" +
								"Taro,Tanaka,test@triangle-sauce.com,\"build&scrap,inc\",\"1-11-17 Ebisu\",,\"Shibuya Ward\",Tokyo,13,Japan,JP,150-0022,1234567,no,\"tag1,tag2,tag3\",triangle-sauce,no,global,test-key,test-value,string\n");
	}

}
