package com.trianglesauce.factory;

import com.trianglesauce.dto.ProductCsv;
import com.trianglesauce.dto.ProductCsvBuilder;
import com.trianglesauce.enums.MetafieldValueType;
import com.trianglesauce.enums.VariantFullfillmentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;

class ProductCsvFactoryTest {

	private final ProductCsvFactory factory = new ProductCsvFactory();

	@Test
	void create() throws Exception {
		ZonedDateTime publishedAt = ZonedDateTime.of(
				LocalDate.of(2020, 5, 10),
				LocalTime.MIN,
				ZoneId.of("JST", ZoneId.SHORT_IDS));

		ProductCsv productCsv = new ProductCsvBuilder()
				.withHandle("titan-t-shirt")
				.withTitle("Titan t-shirt")
				.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
				.withVendor("Titan Incorporated")
				.withPublishedAt(publishedAt)
				.withOption1Name("Color")
				.withOption1Value("red")
				.withOption2Name("Size")
				.withOption2Value("small")
				.withOption3Name("Material")
				.withOption3Value("wool")
				.withVariantSKU("IPOD2008PINK")
				.withVariantFullfillmentService(VariantFullfillmentService.HANDLE_OF_THE_FULFILLMENT_SERVICE)
				.withMetafieldKey("test-key")
				.withMetafieldValue("test-value")
				.withMetafieldValueType(MetafieldValueType.STRING)
				.build();

		Assertions.assertThat(factory.create(Collections.singletonList(productCsv)))
				.isEqualTo(
						"Handle,Title,Body,Vendor,Type,Tags,\"Template Suffix\",\"Published Scope\",Published,\"Published At\",\"Option1 Name\",\"Option1 Value\",\"Option2 Name\",\"Option2 Value\",\"Option3 Name\",\"Option3 Value\",\"Variant SKU\",\"Metafields Global Title Tag\",\"Metafields Global Description Tag\",\"Metafield Namespace\",\"Metafield Key\",\"Metafield Value\",\"Metafield Value Type\",\"Variant Grams\",\"Variant Inventory Trackers\",\"Variant Inventory Qty\",\"Variant Inventory Policy\",\"Variant Inventory Cost\",\"Variant Fullfillment Service\",\"Variant Price\",\"Variant Compare At Price\",\"Variant Requires Shipping\",\"Variant Taxable\",\"Variant Barcode\",\"Image Attachment\",\"Image Src\",\"Image Position\",\"Image Alt Text\",\"Variant Image\",\"Variant Weight\",\"Variant Weight Unit\",\"Variant Tax Code\"\n" +
								"titan-t-shirt,\"Titan t-shirt\",\"You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>\",\"Titan Incorporated\",,,,,,\"2020-05-10T00:00:00+09:00\",Color,red,Size,small,Material,wool,IPOD2008PINK,,,,test-key,test-value,string,,,,,,\"handle of the fulfillment service\",,,,,,,,,,,,,\n");
	}

}
