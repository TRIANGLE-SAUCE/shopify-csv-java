package com.trianglesauce.validator;

import com.trianglesauce.dto.ProductCsv;
import com.trianglesauce.enums.VariantFulfillmentService;
import com.trianglesauce.util.Assert;

public class ProductCsvValidator implements CsvValidator<ProductCsv> {

	private static final int OPTIONAL_NAME_LENGTH = 255;
	private static final int IMAGE_ALT_TEXT_LENGTH = 512;

	private ProductCsvValidator() {}

	public static ProductCsvValidator getInstance() {
		return new ProductCsvValidator();
	}

	@Override
	public void validate(ProductCsv productCsv) {
		// handle
		Assert.notNull(productCsv.getHandle(), "handle must not be null.");

		// title
		Assert.notNull(productCsv.getTitle(), "title must not be null.");

		// tags
		if (hasText(productCsv.getTags()) && productCsv.getTags().length() > getTagsLength()) {
			throw new IllegalArgumentException("tags must not be greater than " + getTagsLength() + ".");
		}

		// published
		validatePublished(productCsv);

		// option1 name
		if (hasText(productCsv.getOption1Name()) && productCsv.getOption1Name().length() > OPTIONAL_NAME_LENGTH) {
			throw new IllegalArgumentException("option1 name must not be greater than " + OPTIONAL_NAME_LENGTH + ".");
		}

		// option2 name
		if (hasText(productCsv.getOption2Name()) && productCsv.getOption2Name().length() > OPTIONAL_NAME_LENGTH) {
			throw new IllegalArgumentException("option2 name must not be greater than " + OPTIONAL_NAME_LENGTH + ".");
		}

		// option3 name
		if (hasText(productCsv.getOption3Name()) && productCsv.getOption3Name().length() > OPTIONAL_NAME_LENGTH) {
			throw new IllegalArgumentException("option3 name must not be greater than " + OPTIONAL_NAME_LENGTH + ".");
		}

		// variant
		validateVariant(productCsv);

		if (hasText(productCsv.getImageAltText()) && productCsv.getImageAltText().length() > IMAGE_ALT_TEXT_LENGTH) {
			throw new IllegalArgumentException("image alt text must not be greater than " + IMAGE_ALT_TEXT_LENGTH + ".");
		}
	}

	private void validatePublished(ProductCsv productCsv) {
		if (productCsv.getPublished() == null) {
			return;
		}
		if (!productCsv.getPublished() && productCsv.getPublishedAt() != null) {
			throw new IllegalArgumentException("publishedAt cannot be specified when published is false.");
		}
	}

	private void validateVariant(ProductCsv productCsv) {
		if (productCsv.getVariantFulfillmentService() == VariantFulfillmentService.HANDLE_OF_THE_FULFILLMENT_SERVICE) {
			Assert.notNull(productCsv.getVariantSKU(), "variant sku must be specified when variant fulfillment service is handle of the fulfillment service.");
		} else if (productCsv.getVariantSKU() != null){
			throw new IllegalArgumentException("variant fulfillment service must be handle of the fulfillment service when variant sku is specified.");
		}

		if (productCsv.getVariantGrams() != null && productCsv.getVariantWeight() != null) {
			throw new IllegalArgumentException("Both variant grams and variant weight cannot be specified.");
		}

		if (productCsv.getVariantGrams() != null && productCsv.getVariantWeightUnit() != null) {
			throw new IllegalArgumentException("Both variant grams and variant weight unit cannot be specified.");
		}

		if (productCsv.getVariantInventoryQty() != null) {
			Assert.positive(productCsv.getVariantInventoryQty(), "variant inventory qty must be a positive number.");
		}
	}
}
