package com.trianglesauce.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

class ProductCsvTest {

	@Test
	void createProductCsv() {
		ZonedDateTime jstNow = ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS));
		ProductCsv actual = new ProductCsvBuilder()
				.withHandle("titan-t-shirt")
				.withTitle("Titan t-shirt")
				.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
				.withVendor("Titan Incorporated")
				.withPublishedAt(jstNow)
				.withOption1Name("Color")
				.withOption1Value("red")
				.withOption2Name("Size")
				.withOption2Value("small")
				.withOption3Name("Material")
				.withOption3Value("wool")
				.withVariantSKU("IPOD2008PINK")
				.withMetafieldNamespace("global")
				.build();

		Assertions.assertThat(actual)
				.extracting(
						ProductCsv::getHandle,
						ProductCsv::getTitle,
						ProductCsv::getBody,
						ProductCsv::getVendor,
						ProductCsv::getType,
						ProductCsv::getTags,
						ProductCsv::getTemplateSuffix,
						ProductCsv::getPublishedScope,
						ProductCsv::getPublished,
						ProductCsv::getPublishedAt,
						ProductCsv::getOption1Name,
						ProductCsv::getOption1Value,
						ProductCsv::getOption2Name,
						ProductCsv::getOption2Value,
						ProductCsv::getOption3Name,
						ProductCsv::getOption3Value,
						ProductCsv::getVariantSKU,
						ProductCsv::getMetafieldNamespace,
						ProductCsv::getVariantInventoryPolicy,
						ProductCsv::getVariantFullfillmentService,
						ProductCsv::getVariantRequiresShipping,
						ProductCsv::getVariantTaxable,
						ProductCsv::getVariantWeight)
				.containsExactly(
						"titan-t-shirt",
						"Titan t-shirt",
						"You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>",
						"Titan Incorporated",
						null,
						null,
						null,
						null,
						null,
						jstNow,
						"Color",
						"red",
						"Size",
						"small",
						"Material",
						"wool",
						"IPOD2008PINK",
						"global",
						null,
						null,
						null,
						null,
						null);
	}
}
