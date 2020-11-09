package com.trianglesauce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.trianglesauce.enums.MetafieldValueType;
import com.trianglesauce.enums.PublishScope;
import com.trianglesauce.enums.VariantFullfillmentService;
import com.trianglesauce.enums.VariantInventoryPolicy;
import com.trianglesauce.enums.VariantInventoryTracker;
import com.trianglesauce.enums.VariantWeightUnit;
import com.trianglesauce.serializer.ZonedDateTimeSerializer;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@JsonPropertyOrder({
		"Handle", "Title", "Body", "Vendor", "Type", "Tags", "Template Suffix", "Published Scope",
		"Published", "Published At", "Option1 Name", "Option1 Value", "Option2 Name", "Option2 Value",
		"Option3 Name", "Option3 Value", "Variant SKU", "Metafields Global Title Tag",
		"Metafields Global Description Tag", "Metafield Namespace", "Metafield Key", "Metafield Value",
		"Metafield Value Type", "Variant Grams", "Variant Inventory Trackers", "Variant Inventory Qty",
		"Variant Inventory Policy", "Variant Inventory Cost", "Variant Fullfillment Service",
		"Variant Price", "Variant Compare At Price", "Variant Requires Shipping", "Variant Taxable",
		"Variant Barcode", "Image Attachment", "Image Src", "Image Position", "Image Alt Text",
		"Variant Image", "Variant Weight", "Variant Weight Unit", "Variant Tax Code",
})
public final class ProductCsv implements Csv {
	@JsonProperty("Handle")
	private final String handle;
	@JsonProperty("Title")
	private final String title;
	@JsonProperty("Body")
	private final String body;
	@JsonProperty("Vendor")
	private final String vendor;
	@JsonProperty("Type")
	private final String type;
	@JsonProperty("Tags")
	private final String tags;
	@JsonProperty("Template Suffix")
	private final String templateSuffix;
	@JsonProperty("Published Scope")
	private final PublishScope publishedScope;
	@JsonProperty("Published")
	private final Boolean published;
	@JsonProperty("Published At")
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	private final ZonedDateTime publishedAt;
	@JsonProperty("Option1 Name")
	private final String option1Name;
	@JsonProperty("Option1 Value")
	private final String option1Value;
	@JsonProperty("Option2 Name")
	private final String option2Name;
	@JsonProperty("Option2 Value")
	private final String option2Value;
	@JsonProperty("Option3 Name")
	private final String option3Name;
	@JsonProperty("Option3 Value")
	private final String option3Value;
	@JsonProperty("Variant SKU")
	private final String variantSKU;
	@JsonProperty("Metafields Global Title Tag")
	private final String metafieldsGlobalTitleTag;
	@JsonProperty("Metafields Global Description Tag")
	private final String metafieldsGlobalDescriptionTag;
	@JsonProperty("Metafield Namespace")
	private final String metafieldNamespace;
	@JsonProperty("Metafield Key")
	private final String metafieldKey;
	@JsonProperty("Metafield Value")
	private final String metafieldValue;
	@JsonProperty("Metafield Value Type")
	private final MetafieldValueType metafieldValueType;
	@JsonProperty("Variant Grams")
	private final BigDecimal variantGrams;
	@JsonProperty("Variant Inventory Trackers")
	private final VariantInventoryTracker variantInventoryTracker;
	@JsonProperty("Variant Inventory Qty")
	private final Integer variantInventoryQty;
	@JsonProperty("Variant Inventory Policy")
	private final VariantInventoryPolicy variantInventoryPolicy;
	@JsonProperty("Variant Inventory Cost")
	private final String variantInventoryCost;
	@JsonProperty("Variant Fullfillment Service")
	private final VariantFullfillmentService variantFullfillmentService;
	@JsonProperty("Variant Price")
	private final BigDecimal variantPrice;
	@JsonProperty("Variant Compare At Price")
	private final Integer variantCompareAtPrice;
	@JsonProperty("Variant Requires Shipping")
	private final Boolean variantRequiresShipping;
	@JsonProperty("Variant Taxable")
	private final Boolean variantTaxable;
	@JsonProperty("Variant Barcode")
	private final String variantBarcode;
	@JsonProperty("Image Attachment")
	private final byte[] imageAttachment;
	@JsonProperty("Image Src")
	private final String imageSrc;
	@JsonProperty("Image Position")
	private final Integer imagePosition;
	@JsonProperty("Image Alt Text")
	private final String imageAltText;
	@JsonProperty("Variant Image")
	private final String variantImage;
	@JsonProperty("Variant Weight")
	private final BigDecimal variantWeight;
	@JsonProperty("Variant Weight Unit")
	private final VariantWeightUnit variantWeightUnit;
	@JsonProperty("Variant Tax Code")
	private final String variantTaxCode;

	public String getHandle() {
		return handle;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public String getVendor() {
		return vendor;
	}

	public String getType() {
		return type;
	}

	public String getTags() {
		return tags;
	}

	public String getTemplateSuffix() {
		return templateSuffix;
	}

	public PublishScope getPublishedScope() {
		return publishedScope;
	}

	public Boolean getPublished() {
		return published;
	}

	public ZonedDateTime getPublishedAt() {
		return publishedAt;
	}

	public String getOption1Name() {
		return option1Name;
	}

	public String getOption1Value() {
		return option1Value;
	}

	public String getOption2Name() {
		return option2Name;
	}

	public String getOption2Value() {
		return option2Value;
	}

	public String getOption3Name() {
		return option3Name;
	}

	public String getOption3Value() {
		return option3Value;
	}

	public String getVariantSKU() {
		return variantSKU;
	}

	public String getMetafieldsGlobalTitleTag() {
		return metafieldsGlobalTitleTag;
	}

	public String getMetafieldsGlobalDescriptionTag() {
		return metafieldsGlobalDescriptionTag;
	}

	public String getMetafieldNamespace() {
		return metafieldNamespace;
	}

	public String getMetafieldKey() {
		return metafieldKey;
	}

	public String getMetafieldValue() {
		return metafieldValue;
	}

	public MetafieldValueType getMetafieldValueType() {
		return metafieldValueType;
	}

	public BigDecimal getVariantGrams() {
		return variantGrams;
	}

	public VariantInventoryTracker getVariantInventoryTracker() {
		return variantInventoryTracker;
	}

	public Integer getVariantInventoryQty() {
		return variantInventoryQty;
	}

	public VariantInventoryPolicy getVariantInventoryPolicy() {
		return variantInventoryPolicy;
	}

	public String getVariantInventoryCost() {
		return variantInventoryCost;
	}

	public VariantFullfillmentService getVariantFullfillmentService() {
		return variantFullfillmentService;
	}

	public BigDecimal getVariantPrice() {
		return variantPrice;
	}

	public Integer getVariantCompareAtPrice() {
		return variantCompareAtPrice;
	}

	public Boolean getVariantRequiresShipping() {
		return variantRequiresShipping;
	}

	public Boolean getVariantTaxable() {
		return variantTaxable;
	}

	public String getVariantBarcode() {
		return variantBarcode;
	}

	public byte[] getImageAttachment() {
		return imageAttachment;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public Integer getImagePosition() {
		return imagePosition;
	}

	public String getImageAltText() {
		return imageAltText;
	}

	public String getVariantImage() {
		return variantImage;
	}

	public BigDecimal getVariantWeight() {
		return variantWeight;
	}

	public VariantWeightUnit getVariantWeightUnit() {
		return variantWeightUnit;
	}

	public String getVariantTaxCode() {
		return variantTaxCode;
	}

	public boolean hasMetafield() {
		return getMetafieldNamespace() != null;
	}

	ProductCsv(
			String handle,
			String title,
			String body,
			String vendor,
			String type,
			String tags,
			String templateSuffix,
			PublishScope publishedScope,
			Boolean published,
			ZonedDateTime publishedAt,
			String option1Name,
			String option1Value,
			String option2Name,
			String option2Value,
			String option3Name,
			String option3Value,
			String variantSKU,
			String metafieldsGlobalTitleTag,
			String metafieldsGlobalDescriptionTag,
			String metafieldNamespace,
			String metafieldKey,
			String metafieldValue,
			MetafieldValueType metafieldValueType,
			BigDecimal variantGrams,
			VariantInventoryTracker variantInventoryTracker,
			Integer variantInventoryQty,
			VariantInventoryPolicy variantInventoryPolicy,
			String variantInventoryCost,
			VariantFullfillmentService variantFullfillmentService,
			BigDecimal variantPrice,
			Integer variantCompareAtPrice,
			Boolean variantRequiresShipping,
			Boolean variantTaxable,
			String variantBarcode,
			byte[] imageAttachment,
			String imageSrc,
			Integer imagePosition,
			String imageAltText,
			String variantImage,
			BigDecimal variantWeight,
			VariantWeightUnit variantWeightUnit,
			String variantTaxCode) {
		this.handle = handle;
		this.title = title;
		this.body = body;
		this.vendor = vendor;
		this.type = type;
		this.tags = tags;
		this.templateSuffix = templateSuffix;
		this.publishedScope = publishedScope;
		this.published = published;
		this.publishedAt = publishedAt;
		this.option1Name = option1Name;
		this.option1Value = option1Value;
		this.option2Name = option2Name;
		this.option2Value = option2Value;
		this.option3Name = option3Name;
		this.option3Value = option3Value;
		this.variantSKU = variantSKU;
		this.metafieldsGlobalTitleTag = metafieldsGlobalTitleTag;
		this.metafieldsGlobalDescriptionTag = metafieldsGlobalDescriptionTag;
		this.metafieldNamespace = metafieldNamespace;
		this.metafieldKey = metafieldKey;
		this.metafieldValue = metafieldValue;
		this.metafieldValueType = metafieldValueType;
		this.variantGrams = variantGrams;
		this.variantInventoryTracker = variantInventoryTracker;
		this.variantInventoryQty = variantInventoryQty;
		this.variantInventoryPolicy = variantInventoryPolicy;
		this.variantInventoryCost = variantInventoryCost;
		this.variantFullfillmentService = variantFullfillmentService;
		this.variantPrice = variantPrice;
		this.variantCompareAtPrice = variantCompareAtPrice;
		this.variantRequiresShipping = variantRequiresShipping;
		this.variantTaxable = variantTaxable;
		this.variantBarcode = variantBarcode;
		this.imageAttachment = imageAttachment;
		this.imageSrc = imageSrc;
		this.imagePosition = imagePosition;
		this.imageAltText = imageAltText;
		this.variantImage = variantImage;
		this.variantWeight = variantWeight;
		this.variantWeightUnit = variantWeightUnit;
		this.variantTaxCode = variantTaxCode;
	}
}
