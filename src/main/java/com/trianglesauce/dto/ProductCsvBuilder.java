package com.trianglesauce.dto;

import com.trianglesauce.enums.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class ProductCsvBuilder {
    private String handle;
    private String title;
    private String body;
    private String vendor;
    private String type;
    private String tags;
    private String templateSuffix;
    private PublishScope publishedScope;
    private Boolean published;
    private ZonedDateTime publishedAt;
    private String option1Name;
    private String option1Value;
    private String option2Name;
    private String option2Value;
    private String option3Name;
    private String option3Value;
    private String variantSKU;
    private BigDecimal variantGrams;
    private VariantInventoryTracker variantInventoryTracker;
    private Integer variantInventoryQty;
    private VariantInventoryPolicy variantInventoryPolicy;
    private String variantInventoryCost;
    private VariantFulfillmentService variantFulfillmentService;
    private BigDecimal variantPrice;
    private Integer variantCompareAtPrice;
    private Boolean variantRequiresShipping;
    private Boolean variantTaxable;
    private String variantBarcode;
    private byte[] imageAttachment;
    private String imageSrc;
    private Integer imagePosition;
    private String imageAltText;
    private String variantImage;
    private BigDecimal variantWeight;
    private VariantWeightUnit variantWeightUnit;
    private String variantTaxCode;

    public ProductCsvBuilder withHandle(String handle) {
        this.handle = handle;
        return this;
    }

    public ProductCsvBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ProductCsvBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public ProductCsvBuilder withVendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public ProductCsvBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public ProductCsvBuilder withTags(String tags) {
        this.tags = tags;
        return this;
    }

    public ProductCsvBuilder withTemplateSuffix(String templateSuffix) {
        this.templateSuffix = templateSuffix;
        return this;
    }

    public ProductCsvBuilder withPublishedScope(PublishScope publishedScope) {
        this.publishedScope = publishedScope;
        return this;
    }

    public ProductCsvBuilder withPublished(Boolean published) {
        this.published = published;
        return this;
    }

    public ProductCsvBuilder withPublishedAt(ZonedDateTime publishedAt) {
        this.publishedAt = publishedAt;
        return this;
    }

    public ProductCsvBuilder withOption1Name(String option1Name) {
        this.option1Name = option1Name;
        return this;
    }

    public ProductCsvBuilder withOption1Value(String option1Value) {
        this.option1Value = option1Value;
        return this;
    }

    public ProductCsvBuilder withOption2Name(String option2Name) {
        this.option2Name = option2Name;
        return this;
    }

    public ProductCsvBuilder withOption2Value(String option2Value) {
        this.option2Value = option2Value;
        return this;
    }

    public ProductCsvBuilder withOption3Name(String option3Name) {
        this.option3Name = option3Name;
        return this;
    }

    public ProductCsvBuilder withOption3Value(String option3Value) {
        this.option3Value = option3Value;
        return this;
    }

    public ProductCsvBuilder withVariantSKU(String variantSKU) {
        this.variantSKU = variantSKU;
        return this;
    }

    public ProductCsvBuilder withVariantGrams(BigDecimal variantGrams) {
        this.variantGrams = variantGrams;
        return this;
    }

    public ProductCsvBuilder withVariantInventoryTracker(VariantInventoryTracker variantInventoryTracker) {
        this.variantInventoryTracker = variantInventoryTracker;
        return this;
    }

    public ProductCsvBuilder withVariantInventoryQty(Integer variantInventoryQty) {
        this.variantInventoryQty = variantInventoryQty;
        return this;
    }

    public ProductCsvBuilder withVariantInventoryPolicy(VariantInventoryPolicy variantInventoryPolicy) {
        this.variantInventoryPolicy = variantInventoryPolicy;
        return this;
    }

    public ProductCsvBuilder withVariantInventoryCost(String variantInventoryCost) {
        this.variantInventoryCost = variantInventoryCost;
        return this;
    }

    public ProductCsvBuilder withVariantFulfillmentService(VariantFulfillmentService variantFulfillmentService) {
        this.variantFulfillmentService = variantFulfillmentService;
        return this;
    }

    public ProductCsvBuilder withVariantPrice(BigDecimal variantPrice) {
        this.variantPrice = variantPrice;
        return this;
    }

    public ProductCsvBuilder withVariantCompareAtPrice(Integer variantCompareAtPrice) {
        this.variantCompareAtPrice = variantCompareAtPrice;
        return this;
    }

    public ProductCsvBuilder withVariantRequiresShipping(Boolean variantRequiresShipping) {
        this.variantRequiresShipping = variantRequiresShipping;
        return this;
    }

    public ProductCsvBuilder withVariantTaxable(Boolean variantTaxable) {
        this.variantTaxable = variantTaxable;
        return this;
    }

    public ProductCsvBuilder withVariantBarcode(String variantBarcode) {
        this.variantBarcode = variantBarcode;
        return this;
    }

    public ProductCsvBuilder withImageAttachment(byte[] imageAttachment) {
        this.imageAttachment = imageAttachment;
        return this;
    }

    public ProductCsvBuilder withImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
        return this;
    }

    public ProductCsvBuilder withImagePosition(Integer imagePosition) {
        this.imagePosition = imagePosition;
        return this;
    }

    public ProductCsvBuilder withImageAltText(String imageAltText) {
        this.imageAltText = imageAltText;
        return this;
    }

    public ProductCsvBuilder withVariantImage(String variantImage) {
        this.variantImage = variantImage;
        return this;
    }

    public ProductCsvBuilder withVariantWeight(BigDecimal variantWeight) {
        this.variantWeight = variantWeight;
        return this;
    }

    public ProductCsvBuilder withVariantWeightUnit(VariantWeightUnit variantWeightUnit) {
        this.variantWeightUnit = variantWeightUnit;
        return this;
    }

    public ProductCsvBuilder withVariantTaxCode(String variantTaxCode) {
        this.variantTaxCode = variantTaxCode;
        return this;
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
                variantGrams,
                variantInventoryTracker,
                variantInventoryQty,
                variantInventoryPolicy,
                variantInventoryCost,
                variantFulfillmentService,
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
