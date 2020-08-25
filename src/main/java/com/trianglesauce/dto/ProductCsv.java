package com.trianglesauce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trianglesauce.enums.MetafieldValueType;
import com.trianglesauce.enums.PublishScope;
import com.trianglesauce.enums.VariantFullfillmentService;
import com.trianglesauce.enums.VariantInventoryPolicy;
import com.trianglesauce.enums.VariantInventoryTracker;
import com.trianglesauce.enums.VariantWeightUnit;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public final class ProductCsv {
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
	private final boolean published;
	@JsonProperty("Published At")
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
	private final int variantInventoryQty;
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
	private final boolean variantRequiresShipping;
	@JsonProperty("Variant Taxable")
	private final boolean variantTaxable;
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

	public boolean isPublished() {
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

	public int getVariantInventoryQty() {
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

	public boolean isVariantRequiresShipping() {
		return variantRequiresShipping;
	}

	public boolean isVariantTaxable() {
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

	private ProductCsv(
			String handle,
			String title,
			String body,
			String vendor,
			String type,
			String tags,
			String templateSuffix,
			PublishScope publishedScope,
			boolean published,
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
			int variantInventoryQty,
			VariantInventoryPolicy variantInventoryPolicy,
			String variantInventoryCost,
			VariantFullfillmentService variantFullfillmentService,
			BigDecimal variantPrice,
			Integer variantCompareAtPrice,
			boolean variantRequiresShipping,
			boolean variantTaxable,
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

	public static class ProductCsvBuilder {
		private String handle;
		private String title;
		private String body;
		private String vendor;
		private String type;
		private String tags = "";
		private String templateSuffix;
		private PublishScope publishedScope = PublishScope.GLOBAL;
		private boolean published = true;
		private ZonedDateTime publishedAt;
		private String option1Name;
		private String option1Value;
		private String option2Name;
		private String option2Value;
		private String option3Name;
		private String option3Value;
		private String variantSKU;
		private String metafieldsGlobalTitleTag;
		private String metafieldsGlobalDescriptionTag;
		private String metafieldNamespace;
		private String metafieldKey;
		private String metafieldValue;
		private MetafieldValueType metafieldValueType;
		private BigDecimal variantGrams;
		private VariantInventoryTracker variantInventoryTracker;
		private int variantInventoryQty;
		private VariantInventoryPolicy variantInventoryPolicy = VariantInventoryPolicy.DENY;
		private String variantInventoryCost;
		private VariantFullfillmentService variantFullfillmentService = VariantFullfillmentService.MANUAL;
		private BigDecimal variantPrice;
		private Integer variantCompareAtPrice;
		private boolean variantRequiresShipping = true;
		private boolean variantTaxable = true;
		private String variantBarcode;
		private byte[] imageAttachment;
		private String imageSrc;
		private Integer imagePosition;
		private String imageAltText;
		private String variantImage;
		private BigDecimal variantWeight;
		private VariantWeightUnit variantWeightUnit;
		private String variantTaxCode;

		private ProductCsvBuilder() {}

		public static ProductCsvBuilder builder() {
			return new ProductCsvBuilder();
		}

		public ProductCsvBuilder handle(String handle) {
			this.handle = handle;
			return this;
		}

		public ProductCsvBuilder title(String title) {
			this.title = title;
			return this;
		}

		public ProductCsvBuilder body(String body) {
			this.body = body;
			return this;
		}

		public ProductCsvBuilder vendor(String vendor) {
			this.vendor = vendor;
			return this;
		}

		public ProductCsvBuilder type(String type) {
			this.type = type;
			return this;
		}

		public ProductCsvBuilder tags(String tags) {
			this.tags = tags;
			return this;
		}

		public ProductCsvBuilder templateSuffix(String templateSuffix) {
			this.templateSuffix = templateSuffix;
			return this;
		}

		public ProductCsvBuilder publishedScope(PublishScope publishedScope) {
			this.publishedScope = publishedScope;
			return this;
		}

		public ProductCsvBuilder published(boolean published) {
			this.published = published;
			return this;
		}

		public ProductCsvBuilder publishedAt(ZonedDateTime publishedAt) {
			this.publishedAt = publishedAt;
			return this;
		}

		public ProductCsvBuilder option1Name(String option1Name) {
			this.option1Name = option1Name;
			return this;
		}

		public ProductCsvBuilder option1Value(String option1Value) {
			this.option1Value = option1Value;
			return this;
		}

		public ProductCsvBuilder option2Name(String option2Name) {
			this.option2Name = option2Name;
			return this;
		}

		public ProductCsvBuilder option2Value(String option2Value) {
			this.option2Value = option2Value;
			return this;
		}

		public ProductCsvBuilder option3Name(String option3Name) {
			this.option3Name = option3Name;
			return this;
		}

		public ProductCsvBuilder option3Value(String option3Value) {
			this.option3Value = option3Value;
			return this;
		}

		public ProductCsvBuilder variantSKU(String variantSKU) {
			this.variantSKU = variantSKU;
			return this;
		}

		public ProductCsvBuilder metafieldsGlobalTitleTag(String metafieldsGlobalTitleTag) {
			this.metafieldsGlobalTitleTag = metafieldsGlobalTitleTag;
			return this;
		}

		public ProductCsvBuilder metafieldsGlobalDescriptionTag(String metafieldsGlobalDescriptionTag) {
			this.metafieldsGlobalDescriptionTag = metafieldsGlobalDescriptionTag;
			return this;
		}

		public ProductCsvBuilder metafieldNamespace(String metafieldNamespace) {
			this.metafieldNamespace = metafieldNamespace;
			return this;
		}

		public ProductCsvBuilder metafieldKey(String metafieldKey) {
			this.metafieldKey = metafieldKey;
			return this;
		}

		public ProductCsvBuilder metafieldValue(String metafieldValue) {
			this.metafieldValue = metafieldValue;
			return this;
		}

		public ProductCsvBuilder metafieldValueType(MetafieldValueType metafieldValueType) {
			this.metafieldValueType = metafieldValueType;
			return this;
		}

		public ProductCsvBuilder variantGrams(BigDecimal variantGrams) {
			this.variantGrams = variantGrams;
			return this;
		}

		public ProductCsvBuilder variantInventoryTracker(VariantInventoryTracker variantInventoryTracker) {
			this.variantInventoryTracker = variantInventoryTracker;
			return this;
		}

		public ProductCsvBuilder variantInventoryQty(int variantInventoryQty) {
			this.variantInventoryQty = variantInventoryQty;
			return this;
		}

		public ProductCsvBuilder variantInventoryPolicy(VariantInventoryPolicy variantInventoryPolicy) {
			this.variantInventoryPolicy = variantInventoryPolicy;
			return this;
		}

		public ProductCsvBuilder variantInventoryCost(String variantInventoryCost) {
			this.variantInventoryCost = variantInventoryCost;
			return this;
		}

		public ProductCsvBuilder variantFullfillmentService(VariantFullfillmentService variantFullfillmentService) {
			this.variantFullfillmentService = variantFullfillmentService;
			return this;
		}

		public ProductCsvBuilder variantPrice(BigDecimal variantPrice) {
			this.variantPrice = variantPrice;
			return this;
		}

		public ProductCsvBuilder variantCompareAtPrice(Integer variantCompareAtPrice) {
			this.variantCompareAtPrice = variantCompareAtPrice;
			return this;
		}

		public ProductCsvBuilder variantRequiresShipping(boolean variantRequiresShipping) {
			this.variantRequiresShipping = variantRequiresShipping;
			return this;
		}

		public ProductCsvBuilder variantTaxable(boolean variantTaxable) {
			this.variantTaxable = variantTaxable;
			return this;
		}

		public ProductCsvBuilder variantBarcode(String variantBarcode) {
			this.variantBarcode = variantBarcode;
			return this;
		}

		public ProductCsvBuilder imageAttachment(byte[] imageAttachment) {
			this.imageAttachment = imageAttachment;
			return this;
		}

		public ProductCsvBuilder imageSrc(String imageSrc) {
			this.imageSrc = imageSrc;
			return this;
		}

		public ProductCsvBuilder imagePosition(Integer imagePosition) {
			this.imagePosition = imagePosition;
			return this;
		}

		public ProductCsvBuilder imageAltText(String imageAltText) {
			this.imageAltText = imageAltText;
			return this;
		}

		public ProductCsvBuilder variantImage(String variantImage) {
			this.variantImage = variantImage;
			return this;
		}

		public ProductCsvBuilder variantWeight(BigDecimal variantWeight) {
			this.variantWeight = variantWeight;
			return this;
		}

		public ProductCsvBuilder variantWeightUnit(VariantWeightUnit variantWeightUnit) {
			this.variantWeightUnit = variantWeightUnit;
			return this;
		}

		public ProductCsvBuilder variantTaxCode(String variantTaxCode) {
			this.variantTaxCode = variantTaxCode;
			return this;
		}

		private boolean hasMetafield() {
			return metafieldKey != null || metafieldValue != null || metafieldValueType != null;
		}

		public ProductCsv build() {
			return new ProductCsv(
					handle,
					title,
					body,
					vendor,
					type,
					tags,
					templateSuffix,
					publishedScope,
					published,
					publishedAt,
					option1Name,
					option1Value,
					option2Name,
					option2Value,
					option3Name,
					option3Value,
					variantSKU,
					metafieldsGlobalTitleTag,
					metafieldsGlobalDescriptionTag,
					metafieldNamespace == null && hasMetafield() ? "global" : metafieldNamespace,
					metafieldKey,
					metafieldValue,
					metafieldValueType,
					variantGrams,
					variantInventoryTracker,
					variantInventoryQty,
					variantInventoryPolicy,
					variantInventoryCost,
					variantFullfillmentService,
					variantPrice,
					variantCompareAtPrice,
					variantRequiresShipping,
					variantTaxable,
					variantBarcode,
					imageAttachment,
					imageSrc,
					imagePosition,
					imageAltText,
					variantImage,
					variantWeight,
					variantWeightUnit,
					variantTaxCode);
		}
	}
}
