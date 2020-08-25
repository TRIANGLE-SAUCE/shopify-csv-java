package com.trianglesauce.validator;

import com.trianglesauce.dto.ProductCsv;
import com.trianglesauce.enums.VariantFullfillmentService;
import com.trianglesauce.util.Assert;

public class ProductCsvValidator implements DtoValidator {

	private static final int TAGS_LENGTH = 255;
	private static final int OPTIONAL_NAME_LENGTH = 255;
	private static final int METAFIELD_NAMESPACE_LENGTH = 20;
	private static final int METAFIELD_KEY_LENGTH = 30;
	private static final int IMAGE_ALT_TEXT_LENGTH = 512;

	private ProductCsvValidator() {}

	public static ProductCsvValidator getInstance() {
		return new ProductCsvValidator();
	}

	public void validate(ProductCsv productCsv) {
		// handle
		Assert.notNull(productCsv.getHandle(), "handle must not be null.");

		// title
		Assert.notNull(productCsv.getTitle(), "title must not be null.");

		// tags
		if (hasText(productCsv.getTags()) && productCsv.getTags().length() > TAGS_LENGTH) {
			throw new IllegalArgumentException("tags must not be greater than " + TAGS_LENGTH + ".");
		}

		// published scope
		Assert.notNull(productCsv.getPublishedScope(), "published scope must not be null.");

		// published
		if (!productCsv.isPublished() && productCsv.getPublishedAt() != null) {
			throw new IllegalArgumentException("publishedAt cannot be specified when published is false.");
		}

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

		// metafield
		validateMetafield(productCsv);

		// variant
		validateVariant(productCsv);

		if (hasText(productCsv.getImageAltText()) && productCsv.getImageAltText().length() > IMAGE_ALT_TEXT_LENGTH) {
			throw new IllegalArgumentException("image alt text must not be greater than " + IMAGE_ALT_TEXT_LENGTH + ".");
		}
	}

	private void validateMetafield(ProductCsv productCsv) {
		if (productCsv.hasMetafield()) {
			Assert.notNull(productCsv.getMetafieldKey(), "metafield key must not be null");
			if (productCsv.getMetafieldKey().length() > METAFIELD_KEY_LENGTH) {
				throw new IllegalArgumentException("metafield key must not be greater than " + METAFIELD_KEY_LENGTH + ".");
			}

			Assert.notNull(productCsv.getMetafieldValue(), "metafield value must not be null.");
			Assert.notNull(productCsv.getMetafieldValueType(), "metafield value type must not be null.");

			Assert.notNull(productCsv.getMetafieldNamespace(), "metafield namespace must not be null");
			if (productCsv.getMetafieldNamespace().length() > METAFIELD_NAMESPACE_LENGTH) {
				throw new IllegalArgumentException("metafield namespace must not be greater than " + METAFIELD_NAMESPACE_LENGTH + ".");
			}
		}
	}

	private void validateVariant(ProductCsv productCsv) {
		Assert.notNull(productCsv.getVariantInventoryPolicy(), "variant inventory policy must not be null.");
		Assert.notNull(productCsv.getVariantFullfillmentService(), "variant fullfillment service must not be null.");

		if (productCsv.getVariantFullfillmentService() == VariantFullfillmentService.HANDLE_OF_THE_FULFILLMENT_SERVICE) {
			Assert.notNull(productCsv.getVariantSKU(), "variant sku must be specified when variant fullfillment service is handle of the fullfillment service.");
		} else if (productCsv.getVariantSKU() != null){
			throw new IllegalArgumentException("variant fullfillment service must be handle of the fullfillment service when variant sku is specified.");
		}

		if (productCsv.getVariantGrams() != null && productCsv.getVariantWeight() != null) {
			throw new IllegalArgumentException("Both variant grams and variant weight cannot be specified.");
		}

		if (productCsv.getVariantGrams() != null && productCsv.getVariantWeightUnit() != null) {
			throw new IllegalArgumentException("Both variant grams and variant weight unit cannot be specified.");
		}
	}
}
