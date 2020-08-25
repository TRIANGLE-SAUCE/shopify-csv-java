package com.trianglesauce.validator;

import com.trianglesauce.dto.ProductCsv;
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
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.handle("titan-t-shirt")
					.title("Titan t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name("Color")
					.option1Value("red")
					.option2Name("Size")
					.option2Value("small")
					.option3Name("Material")
					.option3Value("wool")
					.variantSKU("IPOD2008PINK")
					.variantFullfillmentService(VariantFullfillmentService.HANDLE_OF_THE_FULFILLMENT_SERVICE)
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
					.build();
			Assertions.assertThatCode(() -> productCsvValidator.validate(productCsv))
					.doesNotThrowAnyException();
		}

		@Test
		void handleNotNull() {
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.title("Titan t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name("Color")
					.option1Value("red")
					.option2Name("Size")
					.option2Value("small")
					.option3Name("Material")
					.option3Value("wool")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("handle must not be null.");
		}

		@Test
		void titleNotNull() {
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.handle("titan-t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name("Color")
					.option1Value("red")
					.option2Name("Size")
					.option2Value("small")
					.option3Name("Material")
					.option3Value("wool")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
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
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.handle("titan-t-shirt")
					.title("Titan t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name("Color")
					.option1Value("red")
					.option2Name("Size")
					.option2Value("small")
					.option3Name("Material")
					.option3Value("wool")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
					.tags(tags)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("tags must not be greater than 255.");
		}

		@Test
		void publishedScopeNotNull() {
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.handle("titan-t-shirt")
					.title("Titan t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.publishedScope(null)
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name("Color")
					.option1Value("red")
					.option2Name("Size")
					.option2Value("small")
					.option3Name("Material")
					.option3Value("wool")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("published scope must not be null.");
		}

		@Test
		void publishedFalseAndPublishedAtNotNullIsInvalid() {
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.handle("titan-t-shirt")
					.title("Titan t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.published(false)
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name("Color")
					.option1Value("red")
					.option2Name("Size")
					.option2Value("small")
					.option3Name("Material")
					.option3Value("wool")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
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
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.handle("titan-t-shirt")
					.title("Titan t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name(name)
					.option1Value("red")
					.option2Name("Size")
					.option2Value("small")
					.option3Name("Material")
					.option3Value("wool")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
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
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.handle("titan-t-shirt")
					.title("Titan t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name("Color")
					.option1Value("red")
					.option2Name(name)
					.option2Value("small")
					.option3Name("Material")
					.option3Value("wool")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
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
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.handle("titan-t-shirt")
					.title("Titan t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name("Color")
					.option1Value("red")
					.option2Name("Size")
					.option2Value("small")
					.option3Name(name)
					.option3Value("wool")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
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
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.handle("titan-t-shirt")
					.title("Titan t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name("Color")
					.option1Value("red")
					.option2Name("Size")
					.option2Value("small")
					.option3Name("Material")
					.option3Value("wool")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
					.imageAltText(imageAltText)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("image alt text must not be greater than 512.");
		}

		@Test
		void bothVariantGramsAndVariantWeightAreSpecified() {
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.handle("titan-t-shirt")
					.title("Titan t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name("Color")
					.option1Value("red")
					.option2Name("Size")
					.option2Value("small")
					.option3Name("Material")
					.option3Value("wool")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
					.variantGrams(BigDecimal.TEN)
					.variantWeight(BigDecimal.TEN)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("Both variant grams and variant weight cannot be specified.");
		}

		@Test
		void bothVariantGramsAndVariantWeightUnitAreSpecified() {
			ProductCsv productCsv = ProductCsv.ProductCsvBuilder.builder()
					.handle("titan-t-shirt")
					.title("Titan t-shirt")
					.body("You'll be sure to turn heads in this t-shirt made of <b>100% cotton</b>")
					.vendor("Titan Incorporated")
					.publishedAt(ZonedDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS)))
					.option1Name("Color")
					.option1Value("red")
					.option2Name("Size")
					.option2Value("small")
					.option3Name("Material")
					.option3Value("wool")
					.metafieldKey("test-key")
					.metafieldValue("test-value")
					.metafieldValueType(MetafieldValueType.STRING)
					.variantGrams(BigDecimal.TEN)
					.variantWeightUnit(VariantWeightUnit.KG)
					.build();
			Assertions.assertThatThrownBy(() -> productCsvValidator.validate(productCsv))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("Both variant grams and variant weight unit cannot be specified.");
		}
	}
}
