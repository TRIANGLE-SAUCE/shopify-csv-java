package com.trianglesauce.dto;

import com.trianglesauce.enums.PublishScope;
import com.trianglesauce.enums.VariantFullfillmentService;
import com.trianglesauce.enums.VariantInventoryPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

class ProductCsvTest {

	@Test
	void createProductCsv() {
		ZonedDateTime jstNow = ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS));
		ProductCsv actual = ProductCsv.ProductCsvBuilder.builder()
				.handle("titan-t-shirt")
				.title("Titan t-shirt")
				.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
				.vendor("Titan Incorporated")
				.publishedAt(jstNow)
				.option1Name("Color")
				.option1Value("red")
				.option2Name("Size")
				.option2Value("small")
				.option3Name("Material")
				.option3Value("wool")
				.variantSKU("IPOD2008PINK")
				.metafieldNamespace("global")
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
						ProductCsv::isPublished,
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
						ProductCsv::isVariantRequiresShipping,
						ProductCsv::isVariantTaxable,
						ProductCsv::getVariantWeight)
				.containsExactly(
						"titan-t-shirt",
						"Titan t-shirt",
						"You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>",
						"Titan Incorporated",
						null,
						"",
						null,
						PublishScope.GLOBAL,
						true,
						jstNow,
						"Color",
						"red",
						"Size",
						"small",
						"Material",
						"wool",
						"IPOD2008PINK",
						"global",
						VariantInventoryPolicy.DENY,
						VariantFullfillmentService.MANUAL,
						true,
						true,
						null);
	}
}
