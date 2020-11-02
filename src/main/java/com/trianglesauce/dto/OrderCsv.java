package com.trianglesauce.dto;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.trianglesauce.enums.*;
import com.trianglesauce.serializer.ZonedDateTimeSerializer;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@JsonPropertyOrder({
		"Name", "Email", "Financial Status", "Fullfillment Status", "Currency",
		"Buyer Accepts Marketing", "Cancel Reason", "Cancelled At", "Tags",
		"Note", "Phone", "Referring Site", "Processed At", "Source name",
		"Total weight", "Total Tax", "Shipping Company", "Shipping Name",
		"Shipping Phone", "Shipping First Name", "Shpiping Last Name",
		"Shipping Address1", "Shipping Address2", "Shipping City", "Shipping Province",
		"Shipping Province Code", "Shipping Zip", "Shipping Country",
		"Shipping Country Code", "Billing Company", "Billing Name",
		"Billing Phone", "Billing First Name", "Billing Last Name",
		"Billing Address1", "Billing Address2", "Billing City",
		"Billing Province", "Billing Province Code", "Billing Zip",
		"Billing Country", "Billing Country Code", "Lineitem name",
		"Lineitem variant id", "Lineitem quantity", "Lineitem price",
		"Lineitem variant title", "Lineitem compare at price", "Lineitem sku",
		"Lineitem requires shipping", "Lineitem taxable", "Lineitem fullfillment status",
		"Taxes Included", "Tax 1 Title", "Tax 1 Price", "Tax 1 Rate",
		"Tax 2 Title", "Tax 2 Price", "Tax 3 Rate", "Tax 3 Title", "Tax 3 Price",
		"Tax 3 Rate", "Transaction Amount", "Transaction Kind", "Transaction Status",
		"Transaction Processed At", "Transaction Gateway", "Transaction Localtion Id",
		"Transaction Source Name", "Shipping Line Code", "Shipping Line Price",
		"Shipping Line Source", "Shipping Line Title", "Shipping Line Carrier Identifier",
		"Shipping Line Requested Fullfillment Service Id", "Shipping Tax 1 Title",
		"Shipping Tax 1 Rate", "Shipping Tax 1 Price", "Discount Code",
		"Discount Amount", "Discount Type", "Metafield Namespace", "Metafield Key",
		"Metafield Value", "Metafield Value Type"
})
public final class OrderCsv implements Csv {
	@JsonProperty("Name")
	private final String name;
	@JsonProperty("Email")
	private final String email;
	@JsonProperty("Financial Status")
	private final FinancialStatus financialStatus;
	@JsonProperty("Fullfillment Status")
	private final FulfillmentStatus fulfillmentStatus;
	@JsonProperty("Currency")
	private final String currency;
	@JsonProperty("Buyer Accepts Marketing")
	private final BuyerAcceptsMarketing buyerAcceptsMarketing;
	@JsonProperty("Cancel Reason")
	private final CancelReason cancelReason;
	@JsonProperty("Cancelled At")
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	private final ZonedDateTime cancelledAt;
	@JsonProperty("Tags")
	private final String tags;
	@JsonProperty("Note")
	private final String note;
	@JsonProperty("Phone")
	private final String phone;
	@JsonProperty("Referring Site")
	private final String referringSite;
	@JsonProperty("Processed At")
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	private final ZonedDateTime processedAt;
	@JsonProperty("Source name")
	private final String sourcename;
	@JsonProperty("Total weight")
	private final Integer totalWeight;
	@JsonProperty("Total Tax")
	private final BigDecimal totalTax;
	@JsonProperty("Shipping Company")
	private final String shippingCompany;
	@JsonProperty("Shipping Name")
	private final String shippingName;
	@JsonProperty("Shipping Phone")
	private final String shippingPhone;
	@JsonProperty("Shipping First Name")
	private final String shippingFirstName;
	@JsonProperty("Shpiping Last Name")
	private final String shippingLastName;
	@JsonProperty("Shipping Address1")
	private final String shippingAddress1;
	@JsonProperty("Shipping Address2")
	private final String shippingAddress2;
	@JsonProperty("Shipping City")
	private final String shippingCity;
	@JsonProperty("Shipping Province")
	private final String shippingProvince;
	@JsonProperty("Shipping Province Code")
	private final String shippingProvinceCode;
	@JsonProperty("Shipping Zip")
	private final String shippingZip;
	@JsonProperty("Shipping Country")
	private final String shippingCountry;
	@JsonProperty("Shipping Country Code")
	private final String shippingCountyCode;
	@JsonProperty("Billing Company")
	private final String billingCompany;
	@JsonProperty("Billing Name")
	private final String billingName;
	@JsonProperty("Billing Phone")
	private final String billingPhone;
	@JsonProperty("Billing First Name")
	private final String billingFirstName;
	@JsonProperty("Billing Last Name")
	private final String billingLastName;
	@JsonProperty("Billing Address1")
	private final String billingAddress1;
	@JsonProperty("Billing Address2")
	private final String billingAddress2;
	@JsonProperty("Billing City")
	private final String billingCity;
	@JsonProperty("Billing Province")
	private final String billingProvince;
	@JsonProperty("Billing Province Code")
	private final String billingProvinceCode;
	@JsonProperty("Billing Zip")
	private final String billingZip;
	@JsonProperty("Billing Country")
	private final String billingCountry;
	@JsonProperty("Billing Country Code")
	private final String billingCountryCode;
	@JsonProperty("Lineitem name")
	private final String lineitemName;
	@JsonProperty("Lineitem variant id")
	private final String lineitemVariantId;
	@JsonProperty("Lineitem quantity")
	private final Integer lineitemQuantity;
	@JsonProperty("Lineitem price")
	private final String lineitemPrice;
	@JsonProperty("Lineitem variant title")
	private final String lineitemVariantTitle;
	@JsonProperty("Lineitem compare at price")
	private final String lineitemCompareAtPrice;
	@JsonProperty("Lineitem sku")
	private final String lineitemSku;
	@JsonProperty("Lineitem requires shipping")
	private final Boolean lineitemRequiresShipping;
	@JsonProperty("Lineitem taxable")
	private final Boolean lineitemTaxable;;
	@JsonProperty("Lineitem fullfillment status")
	private final String lineitemFullfillmentStatus;
	@JsonProperty("Taxes Included")
	private final boolean taxesIncluded;
	@JsonProperty("Tax 1 Title")
	private final String tax1Title;
	@JsonProperty("Tax 1 Price")
	private final BigDecimal tax1Price;
	@JsonProperty("Tax 1 Rate")
	private final String tax1Rate;
	@JsonProperty("Tax 2 Title")
	private final String tax2Title;
	@JsonProperty("Tax 2 Price")
	private final BigDecimal tax2Price;
	@JsonProperty("Tax 3 Rate")
	private final String tax2Rate;
	@JsonProperty("Tax 3 Title")
	private final String tax3Title;
	@JsonProperty("Tax 3 Price")
	private final BigDecimal tax3Price;
	@JsonProperty("Tax 3 Rate")
	private final String tax3Rate;
	@JsonProperty("Transaction Amount")
	private final BigDecimal transactionAmount;
	@JsonProperty("Transaction Kind")
	private final TransactionKind transactionKind;
	@JsonProperty("Transaction Status")
	private final TransactionStatus transactionStatus;
	@JsonProperty("Transaction Processed At")
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	private final String transactionProcessedAt;
	@JsonProperty("Transaction Gateway")
	private final String transactionGateway;
	@JsonProperty("Transaction Localtion Id")
	private final String transactionLocationId;
	@JsonProperty("Transaction Source Name")
	private final String transactionSourceName;
	@JsonProperty("Shipping Line Code")
	private final String shippingLineCode;
	@JsonProperty("Shipping Line Price")
	private final String shippingLinePrice;
	@JsonProperty("Shipping Line Source")
	private final String shippingLineSource;
	@JsonProperty("Shipping Line Title")
	private final String shippingLineTitle;
	@JsonProperty("Shipping Line Carrier Identifier")
	private final String shippingLineCarrierIdentifier;
	@JsonProperty("Shipping Line Requested Fullfillment Service Id")
	private final String shippingLineRequestedFullfillmentServiceId;
	@JsonProperty("Shipping Tax 1 Title")
	private final String shippingTax1Title;
	@JsonProperty("Shipping Tax 1 Rate")
	private final BigDecimal shippingTax1Rate;
	@JsonProperty("Shipping Tax Price")
	private final BigDecimal shippingTaxPrice;
	@JsonProperty("Discount Code")
	private final String discountCode;
	@JsonProperty("Discount Amount")
	private final String discountAmount;
	@JsonProperty("Discount Type")
	private final DiscountType discountType;
	@JsonProperty("Metafield Namespace")
	private final String metafieldNamespace;
	@JsonProperty("Metafield Key")
	private final String metafieldKey;
	@JsonProperty("Metafield Value")
	private final String metafieldValue;
	@JsonProperty("Metafield Value Type")
	private final String metafieldValueType;

	OrderCsv(String name, String email, FinancialStatus financialStatus, FulfillmentStatus fulfillmentStatus, String currency, BuyerAcceptsMarketing buyerAcceptsMarketing, CancelReason cancelReason, ZonedDateTime cancelledAt, String tags, String note, String phone, String referringSite, ZonedDateTime processedAt, String sourcename, Integer totalWeight, BigDecimal totalTax, String shippingCompany, String shippingName, String shippingPhone, String shippingFirstName, String shippingLastName, String shippingAddress1, String shippingAddress2, String shippingCity, String shippingProvince, String shippingProvinceCode, String shippingZip, String shippingCountry, String shippingCountyCode, String billingCompany, String billingName, String billingPhone, String billingFirstName, String billingLastName, String billingAddress1, String billingAddress2, String billingCity, String billingProvince, String billingProvinceCode, String billingZip, String billingCountry, String billingCountryCode, String lineitemName, String lineitemVariantId, Integer lineitemQuantity, String lineitemPrice, String lineitemVariantTitle, String lineitemCompareAtPrice, String lineitemSku, Boolean lineitemRequiresShipping, Boolean lineitemTaxable, String lineitemFullfillmentStatus, boolean taxesIncluded, String tax1Title, BigDecimal tax1Price, String tax1Rate, String tax2Title, BigDecimal tax2Price, String tax2Rate, String tax3Title, BigDecimal tax3Price, String tax3Rate, BigDecimal transactionAmount, TransactionKind transactionKind, TransactionStatus transactionStatus, String transactionProcessedAt, String transactionGateway, String transactionLocationId, String transactionSourceName, String shippingLineCode, String shippingLinePrice, String shippingLineSource, String shippingLineTitle, String shippingLineCarrierIdentifier, String shippingLineRequestedFullfillmentServiceId, String shippingTax1Title, BigDecimal shippingTax1Rate, BigDecimal shippingTaxPrice, String discountCode, String discountAmount, DiscountType discountType, String metafieldNamespace, String metafieldKey, String metafieldValue, String metafieldValueType) {
		this.name = name;
		this.email = email;
		this.financialStatus = financialStatus;
		this.fulfillmentStatus = fulfillmentStatus;
		this.currency = currency;
		this.buyerAcceptsMarketing = buyerAcceptsMarketing;
		this.cancelReason = cancelReason;
		this.cancelledAt = cancelledAt;
		this.tags = tags;
		this.note = note;
		this.phone = phone;
		this.referringSite = referringSite;
		this.processedAt = processedAt;
		this.sourcename = sourcename;
		this.totalWeight = totalWeight;
		this.totalTax = totalTax;
		this.shippingCompany = shippingCompany;
		this.shippingName = shippingName;
		this.shippingPhone = shippingPhone;
		this.shippingFirstName = shippingFirstName;
		this.shippingLastName = shippingLastName;
		this.shippingAddress1 = shippingAddress1;
		this.shippingAddress2 = shippingAddress2;
		this.shippingCity = shippingCity;
		this.shippingProvince = shippingProvince;
		this.shippingProvinceCode = shippingProvinceCode;
		this.shippingZip = shippingZip;
		this.shippingCountry = shippingCountry;
		this.shippingCountyCode = shippingCountyCode;
		this.billingCompany = billingCompany;
		this.billingName = billingName;
		this.billingPhone = billingPhone;
		this.billingFirstName = billingFirstName;
		this.billingLastName = billingLastName;
		this.billingAddress1 = billingAddress1;
		this.billingAddress2 = billingAddress2;
		this.billingCity = billingCity;
		this.billingProvince = billingProvince;
		this.billingProvinceCode = billingProvinceCode;
		this.billingZip = billingZip;
		this.billingCountry = billingCountry;
		this.billingCountryCode = billingCountryCode;
		this.lineitemName = lineitemName;
		this.lineitemVariantId = lineitemVariantId;
		this.lineitemQuantity = lineitemQuantity;
		this.lineitemPrice = lineitemPrice;
		this.lineitemVariantTitle = lineitemVariantTitle;
		this.lineitemCompareAtPrice = lineitemCompareAtPrice;
		this.lineitemSku = lineitemSku;
		this.lineitemRequiresShipping = lineitemRequiresShipping;
		this.lineitemTaxable = lineitemTaxable;
		this.lineitemFullfillmentStatus = lineitemFullfillmentStatus;
		this.taxesIncluded = taxesIncluded;
		this.tax1Title = tax1Title;
		this.tax1Price = tax1Price;
		this.tax1Rate = tax1Rate;
		this.tax2Title = tax2Title;
		this.tax2Price = tax2Price;
		this.tax2Rate = tax2Rate;
		this.tax3Title = tax3Title;
		this.tax3Price = tax3Price;
		this.tax3Rate = tax3Rate;
		this.transactionAmount = transactionAmount;
		this.transactionKind = transactionKind;
		this.transactionStatus = transactionStatus;
		this.transactionProcessedAt = transactionProcessedAt;
		this.transactionGateway = transactionGateway;
		this.transactionLocationId = transactionLocationId;
		this.transactionSourceName = transactionSourceName;
		this.shippingLineCode = shippingLineCode;
		this.shippingLinePrice = shippingLinePrice;
		this.shippingLineSource = shippingLineSource;
		this.shippingLineTitle = shippingLineTitle;
		this.shippingLineCarrierIdentifier = shippingLineCarrierIdentifier;
		this.shippingLineRequestedFullfillmentServiceId = shippingLineRequestedFullfillmentServiceId;
		this.shippingTax1Title = shippingTax1Title;
		this.shippingTax1Rate = shippingTax1Rate;
		this.shippingTaxPrice = shippingTaxPrice;
		this.discountCode = discountCode;
		this.discountAmount = discountAmount;
		this.discountType = discountType;
		this.metafieldNamespace = metafieldNamespace;
		this.metafieldKey = metafieldKey;
		this.metafieldValue = metafieldValue;
		this.metafieldValueType = metafieldValueType;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public FinancialStatus getFinancialStatus() {
		return financialStatus;
	}

	public FulfillmentStatus getFulfillmentStatus() {
		return fulfillmentStatus;
	}

	public String getCurrency() {
		return currency;
	}

	public BuyerAcceptsMarketing getBuyerAcceptsMarketing() {
		return buyerAcceptsMarketing;
	}

	public CancelReason getCancelReason() {
		return cancelReason;
	}

	public ZonedDateTime getCancelledAt() {
		return cancelledAt;
	}

	public String getTags() {
		return tags;
	}

	public String getNote() {
		return note;
	}

	public String getPhone() {
		return phone;
	}

	public String getReferringSite() {
		return referringSite;
	}

	public ZonedDateTime getProcessedAt() {
		return processedAt;
	}

	public String getSourcename() {
		return sourcename;
	}

	public Integer getTotalWeight() {
		return totalWeight;
	}

	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public String getShippingCompany() {
		return shippingCompany;
	}

	public String getShippingName() {
		return shippingName;
	}

	public String getShippingPhone() {
		return shippingPhone;
	}

	public String getShippingFirstName() {
		return shippingFirstName;
	}

	public String getShippingLastName() {
		return shippingLastName;
	}

	public String getShippingAddress1() {
		return shippingAddress1;
	}

	public String getShippingAddress2() {
		return shippingAddress2;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public String getShippingProvince() {
		return shippingProvince;
	}

	public String getShippingProvinceCode() {
		return shippingProvinceCode;
	}

	public String getShippingZip() {
		return shippingZip;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public String getShippingCountyCode() {
		return shippingCountyCode;
	}

	public String getBillingCompany() {
		return billingCompany;
	}

	public String getBillingName() {
		return billingName;
	}

	public String getBillingPhone() {
		return billingPhone;
	}

	public String getBillingFirstName() {
		return billingFirstName;
	}

	public String getBillingLastName() {
		return billingLastName;
	}

	public String getBillingAddress1() {
		return billingAddress1;
	}

	public String getBillingAddress2() {
		return billingAddress2;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public String getBillingProvince() {
		return billingProvince;
	}

	public String getBillingProvinceCode() {
		return billingProvinceCode;
	}

	public String getBillingZip() {
		return billingZip;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public String getBillingCountryCode() {
		return billingCountryCode;
	}

	public String getLineitemName() {
		return lineitemName;
	}

	public String getLineitemVariantId() {
		return lineitemVariantId;
	}

	public Integer getLineitemQuantity() {
		return lineitemQuantity;
	}

	public String getLineitemPrice() {
		return lineitemPrice;
	}

	public String getLineitemVariantTitle() {
		return lineitemVariantTitle;
	}

	public String getLineitemCompareAtPrice() {
		return lineitemCompareAtPrice;
	}

	public String getLineitemSku() {
		return lineitemSku;
	}

	public Boolean getLineitemRequiresShipping() {
		return lineitemRequiresShipping;
	}

	public Boolean getLineitemTaxable() {
		return lineitemTaxable;
	}

	public String getLineitemFullfillmentStatus() {
		return lineitemFullfillmentStatus;
	}

	public boolean isTaxesIncluded() {
		return taxesIncluded;
	}

	public String getTax1Title() {
		return tax1Title;
	}

	public BigDecimal getTax1Price() {
		return tax1Price;
	}

	public String getTax1Rate() {
		return tax1Rate;
	}

	public String getTax2Title() {
		return tax2Title;
	}

	public BigDecimal getTax2Price() {
		return tax2Price;
	}

	public String getTax2Rate() {
		return tax2Rate;
	}

	public String getTax3Title() {
		return tax3Title;
	}

	public BigDecimal getTax3Price() {
		return tax3Price;
	}

	public String getTax3Rate() {
		return tax3Rate;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public TransactionKind getTransactionKind() {
		return transactionKind;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public String getTransactionProcessedAt() {
		return transactionProcessedAt;
	}

	public String getTransactionGateway() {
		return transactionGateway;
	}

	public String getTransactionLocationId() {
		return transactionLocationId;
	}

	public String getTransactionSourceName() {
		return transactionSourceName;
	}

	public String getShippingLineCode() {
		return shippingLineCode;
	}

	public String getShippingLinePrice() {
		return shippingLinePrice;
	}

	public String getShippingLineSource() {
		return shippingLineSource;
	}

	public String getShippingLineTitle() {
		return shippingLineTitle;
	}

	public String getShippingLineCarrierIdentifier() {
		return shippingLineCarrierIdentifier;
	}

	public String getShippingLineRequestedFullfillmentServiceId() {
		return shippingLineRequestedFullfillmentServiceId;
	}

	public String getShippingTax1Title() {
		return shippingTax1Title;
	}

	public BigDecimal getShippingTax1Rate() {
		return shippingTax1Rate;
	}

	public BigDecimal getShippingTaxPrice() {
		return shippingTaxPrice;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public String getDiscountAmount() {
		return discountAmount;
	}

	public DiscountType getDiscountType() {
		return discountType;
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

	public String getMetafieldValueType() {
		return metafieldValueType;
	}

	public boolean hasMetafield() {
		return getMetafieldNamespace() != null;
	}
}
