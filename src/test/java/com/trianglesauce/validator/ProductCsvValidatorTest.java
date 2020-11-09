package com.trianglesauce.validator;

import com.trianglesauce.dto.ProductCsv;
import com.trianglesauce.dto.ProductCsvBuilder;
import com.trianglesauce.enums.MetafieldValueType;
import com.trianglesauce.enums.VariantFullfillmentService;
import com.trianglesauce.enums.VariantWeightUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ProductCsvValidatorTest {

	@Test
	void getInstance() {
		Assertions.assertThat(ProductCsvValidator.getInstance())
				.isInstanceOf(ProductCsvValidator.class);
	}

	@Nested
	class ValidateTest {

		private final ProductCsvValidator productCsvValidator = ProductCsvValidator.getInstance();

		@Test
		void success() {
			ProductCsv productCsv = new ProductCsvBuilder()
					.withHandle("titan-t-shirt")
					.withTitle("Titan t-shirt")
					.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.withVendor("Titan Incorporated")
					.withPublishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
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
			Assertions.assertThatCode(() -> productCsvValidator.validate(productCsv))
					.doesNotThrowAnyException();
		}

		@Test
		void handleNotNull() {
			ProductCsv productCsv = new ProductCsvBuilder()
					.withTitle("Titan t-shirt")
					.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.withVendor("Titan Incorporated")
					.withPublishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.withOption1Name("Color")
					.withOption1Value("red")
					.withOption2Name("Size")
					.withOption2Value("small")
					.withOption3Name("Material")
					.withOption3Value("wool")
					.withMetafieldKey("test-key")
					.withMetafieldValue("test-value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("handle must not be null.");
		}

		@Test
		void titleNotNull() {
			ProductCsv productCsv = new ProductCsvBuilder()
					.withHandle("titan-t-shirt")
					.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.withVendor("Titan Incorporated")
					.withPublishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.withOption1Name("Color")
					.withOption1Value("red")
					.withOption2Name("Size")
					.withOption2Value("small")
					.withOption3Name("Material")
					.withOption3Value("wool")
					.withMetafieldKey("test-key")
					.withMetafieldValue("test-value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("title must not be null.");
		}

		@Test
		void tagsOverLimit() {
			String tags = IntStream.rangeClosed(0, 255)
					.boxed()
					.map(Object::toString)
					.collect(Collectors.joining());
			ProductCsv productCsv = new ProductCsvBuilder()
					.withHandle("titan-t-shirt")
					.withTitle("Titan t-shirt")
					.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.withVendor("Titan Incorporated")
					.withPublishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.withOption1Name("Color")
					.withOption1Value("red")
					.withOption2Name("Size")
					.withOption2Value("small")
					.withOption3Name("Material")
					.withOption3Value("wool")
					.withMetafieldKey("test-key")
					.withMetafieldValue("test-value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.withTags(tags)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("tags must not be greater than 255.");
		}

		@Test
		void publishedFalseAndPublishedAtNotNullIsInvalid() {
			ProductCsv productCsv = new ProductCsvBuilder()
					.withHandle("titan-t-shirt")
					.withTitle("Titan t-shirt")
					.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.withVendor("Titan Incorporated")
					.withPublished(false)
					.withPublishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.withOption1Name("Color")
					.withOption1Value("red")
					.withOption2Name("Size")
					.withOption2Value("small")
					.withOption3Name("Material")
					.withOption3Value("wool")
					.withMetafieldKey("test-key")
					.withMetafieldValue("test-value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("publishedAt cannot be specified when published is false.");
		}

		@Test
		void option1NameOverLimit() {
			String name = IntStream.rangeClosed(0, 255)
					.boxed()
					.map(Object::toString)
					.collect(Collectors.joining());
			ProductCsv productCsv = new ProductCsvBuilder()
					.withHandle("titan-t-shirt")
					.withTitle("Titan t-shirt")
					.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.withVendor("Titan Incorporated")
					.withPublishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.withOption1Name(name)
					.withOption1Value("red")
					.withOption2Name("Size")
					.withOption2Value("small")
					.withOption3Name("Material")
					.withOption3Value("wool")
					.withMetafieldKey("test-key")
					.withMetafieldValue("test-value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("option1 name must not be greater than 255.");
		}

		@Test
		void option2NameOverLimit() {
			String name = IntStream.rangeClosed(0, 255)
					.boxed()
					.map(Object::toString)
					.collect(Collectors.joining());
			ProductCsv productCsv = new ProductCsvBuilder()
					.withHandle("titan-t-shirt")
					.withTitle("Titan t-shirt")
					.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.withVendor("Titan Incorporated")
					.withPublishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.withOption1Name("Color")
					.withOption1Value("red")
					.withOption2Name(name)
					.withOption2Value("small")
					.withOption3Name("Material")
					.withOption3Value("wool")
					.withMetafieldKey("test-key")
					.withMetafieldValue("test-value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("option2 name must not be greater than 255.");
		}

		@Test
		void option3NameOverLimit() {
			String name = IntStream.rangeClosed(0, 255)
					.boxed()
					.map(Object::toString)
					.collect(Collectors.joining());
			ProductCsv productCsv = new ProductCsvBuilder()
					.withHandle("titan-t-shirt")
					.withTitle("Titan t-shirt")
					.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.withVendor("Titan Incorporated")
					.withPublishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.withOption1Name("Color")
					.withOption1Value("red")
					.withOption2Name("Size")
					.withOption2Value("small")
					.withOption3Name(name)
					.withOption3Value("wool")
					.withMetafieldKey("test-key")
					.withMetafieldValue("test-value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("option3 name must not be greater than 255.");
		}

		@Test
		void imageAltTextOverLimit() {
			String imageAltText = IntStream.rangeClosed(0, 512)
					.boxed()
					.map(Object::toString)
					.collect(Collectors.joining());
			ProductCsv productCsv = new ProductCsvBuilder()
					.withHandle("titan-t-shirt")
					.withTitle("Titan t-shirt")
					.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.withVendor("Titan Incorporated")
					.withPublishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.withOption1Name("Color")
					.withOption1Value("red")
					.withOption2Name("Size")
					.withOption2Value("small")
					.withOption3Name("Material")
					.withOption3Value("wool")
					.withMetafieldKey("test-key")
					.withMetafieldValue("test-value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.withImageAltText(imageAltText)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("image alt text must not be greater than 512.");
		}

		@Test
		void bothVariantGramsAndVariantWeightAreSpecified() {
			ProductCsv productCsv = new ProductCsvBuilder()
					.withHandle("titan-t-shirt")
					.withTitle("Titan t-shirt")
					.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.withVendor("Titan Incorporated")
					.withPublishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.withOption1Name("Color")
					.withOption1Value("red")
					.withOption2Name("Size")
					.withOption2Value("small")
					.withOption3Name("Material")
					.withOption3Value("wool")
					.withMetafieldKey("test-key")
					.withMetafieldValue("test-value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.withVariantGrams(BigDecimal.TEN)
					.withVariantWeight(BigDecimal.TEN)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("Both variant grams and variant weight cannot be specified.");
		}

		@Test
		void bothVariantGramsAndVariantWeightUnitAreSpecified() {
			ProductCsv productCsv = new ProductCsvBuilder()
					.withHandle("titan-t-shirt")
					.withTitle("Titan t-shirt")
					.withBody("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.withVendor("Titan Incorporated")
					.withPublishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.withOption1Name("Color")
					.withOption1Value("red")
					.withOption2Name("Size")
					.withOption2Value("small")
					.withOption3Name("Material")
					.withOption3Value("wool")
					.withMetafieldKey("test-key")
					.withMetafieldValue("test-value")
					.withMetafieldValueType(MetafieldValueType.STRING)
					.withVariantGrams(BigDecimal.TEN)
					.withVariantWeightUnit(VariantWeightUnit.KG)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("Both variant grams and variant weight unit cannot be specified.");
		}
	}
}
