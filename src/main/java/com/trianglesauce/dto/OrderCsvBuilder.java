package com.trianglesauce.dto;

import com.trianglesauce.enums.*;

import java.math.BigDecimal;
import java.net.URL;
import java.time.ZonedDateTime;

public class OrderCsvBuilder {
	private String name;
	private String email;
	private FinancialStatus financialStatus;
	private FulfillmentStatus fulfillmentStatus;
	private String currency;
	private BuyerAcceptsMarketing buyerAcceptsMarketing;
	private CancelReason cancelReason;
	private ZonedDateTime cancelledAt;
	private String tags;
	private String note;
	private String phone;
	private URL referringSite;
	private ZonedDateTime processedAt;
	private String sourcename;
	private Integer totalWeight;
	private BigDecimal totalTax;
	private String shippingCompany;
	private String shippingName;
	private String shippingPhone;
	private String shippingFirstName;
	private String shippingLastName;
	private String shippingAddress1;
	private String shippingAddress2;
	private String shippingCity;
	private String shippingProvince;
	private String shippingProvinceCode;
	private String shippingZip;
	private String shippingCountry;
	private String shippingCountyCode;
	private String billingCompany;
	private String billingName;
	private String billingPhone;
	private String billingFirstName;
	private String billingLastName;
	private String billingAddress1;
	private String billingAddress2;
	private String billingCity;
	private String billingProvince;
	private String billingProvinceCode;
	private String billingZip;
	private String billingCountry;
	private String billingCountryCode;
	private String lineitemName;
	private String lineitemVariantId;
	private Integer lineitemQuantity;
	private String lineitemPrice;
	private String lineitemVariantTitle;
	private String lineitemCompareAtPrice;
	private String lineitemSku;
	private Boolean lineitemRequiresShipping;
	private Boolean lineitemTaxable;
	private String lineitemFullfillmentStatus;
	private boolean taxesIncluded;
	private String tax1Title;
	private BigDecimal tax1Price;
	private String tax1Rate;
	private String tax2Title;
	private BigDecimal tax2Price;
	private String tax2Rate;
	private String tax3Title;
	private BigDecimal tax3Price;
	private String tax3Rate;
	private BigDecimal transactionAmount;
	private TransactionKind transactionKind;
	private TransactionStatus transactionStatus;
	private String transactionProcessedAt;
	private String transactionGateway;
	private String transactionLocationId;
	private String transactionSourceName;
	private String shippingLineCode;
	private String shippingLinePrice;
	private String shippingLineSource;
	private String shippingLineTitle;
	private String shippingLineCarrierIdentifier;
	private String shippingLineRequestedFullfillmentServiceId;
	private String shippingTax1Title;
	private BigDecimal shippingTax1Rate;
	private BigDecimal shippingTaxPrice;
	private String discountCode;
	private String discountAmount;
	private DiscountType discountType;
	private String metafieldNamespace;
	private String metafieldKey;
	private String metafieldValue;
	private String metafieldValueType;

	public OrderCsvBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public OrderCsvBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	public OrderCsvBuilder withFinancialStatus(FinancialStatus financialStatus) {
		this.financialStatus = financialStatus;
		return this;
	}

	public OrderCsvBuilder withFulfillmentStatus(FulfillmentStatus fulfillmentStatus) {
		this.fulfillmentStatus = fulfillmentStatus;
		return this;
	}

	public OrderCsvBuilder withCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public OrderCsvBuilder withBuyerAcceptsMarketing(BuyerAcceptsMarketing buyerAcceptsMarketing) {
		this.buyerAcceptsMarketing = buyerAcceptsMarketing;
		return this;
	}

	public OrderCsvBuilder withCancelReason(CancelReason cancelReason) {
		this.cancelReason = cancelReason;
		return this;
	}

	public OrderCsvBuilder withCancelledAt(ZonedDateTime cancelledAt) {
		this.cancelledAt = cancelledAt;
		return this;
	}

	public OrderCsvBuilder withTags(String tags) {
		this.tags = tags;
		return this;
	}

	public OrderCsvBuilder withNote(String note) {
		this.note = note;
		return this;
	}

	public OrderCsvBuilder withPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public OrderCsvBuilder withReferringSite(URL referringSite) {
		this.referringSite = referringSite;
		return this;
	}

	public OrderCsvBuilder withProcessedAt(ZonedDateTime processedAt) {
		this.processedAt = processedAt;
		return this;
	}

	public OrderCsvBuilder withSourcename(String sourcename) {
		this.sourcename = sourcename;
		return this;
	}

	public OrderCsvBuilder withTotalWeight(Integer totalWeight) {
		this.totalWeight = totalWeight;
		return this;
	}

	public OrderCsvBuilder withTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
		return this;
	}

	public OrderCsvBuilder withShippingCompany(String shippingCompany) {
		this.shippingCompany = shippingCompany;
		return this;
	}

	public OrderCsvBuilder withShippingName(String shippingName) {
		this.shippingName = shippingName;
		return this;
	}

	public OrderCsvBuilder withShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
		return this;
	}

	public OrderCsvBuilder withShippingFirstName(String shippingFirstName) {
		this.shippingFirstName = shippingFirstName;
		return this;
	}

	public OrderCsvBuilder withShippingLastName(String shippingLastName) {
		this.shippingLastName = shippingLastName;
		return this;
	}

	public OrderCsvBuilder withShippingAddress1(String shippingAddress1) {
		this.shippingAddress1 = shippingAddress1;
		return this;
	}

	public OrderCsvBuilder withShippingAddress2(String shippingAddress2) {
		this.shippingAddress2 = shippingAddress2;
		return this;
	}

	public OrderCsvBuilder withShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
		return this;
	}

	public OrderCsvBuilder withShippingProvince(String shippingProvince) {
		this.shippingProvince = shippingProvince;
		return this;
	}

	public OrderCsvBuilder withShippingProvinceCode(String shippingProvinceCode) {
		this.shippingProvinceCode = shippingProvinceCode;
		return this;
	}

	public OrderCsvBuilder withShippingZip(String shippingZip) {
		this.shippingZip = shippingZip;
		return this;
	}

	public OrderCsvBuilder withShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
		return this;
	}

	public OrderCsvBuilder withShippingCountyCode(String shippingCountyCode) {
		this.shippingCountyCode = shippingCountyCode;
		return this;
	}

	public OrderCsvBuilder withBillingCompany(String billingCompany) {
		this.billingCompany = billingCompany;
		return this;
	}

	public OrderCsvBuilder withBillingName(String billingName) {
		this.billingName = billingName;
		return this;
	}

	public OrderCsvBuilder withBillingPhone(String billingPhone) {
		this.billingPhone = billingPhone;
		return this;
	}

	public OrderCsvBuilder withBillingFirstName(String billingFirstName) {
		this.billingFirstName = billingFirstName;
		return this;
	}

	public OrderCsvBuilder withBillingLastName(String billingLastName) {
		this.billingLastName = billingLastName;
		return this;
	}

	public OrderCsvBuilder withBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
		return this;
	}

	public OrderCsvBuilder withBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
		return this;
	}

	public OrderCsvBuilder withBillingCity(String billingCity) {
		this.billingCity = billingCity;
		return this;
	}

	public OrderCsvBuilder withBillingProvince(String billingProvince) {
		this.billingProvince = billingProvince;
		return this;
	}

	public OrderCsvBuilder withBillingProvinceCode(String billingProvinceCode) {
		this.billingProvinceCode = billingProvinceCode;
		return this;
	}

	public OrderCsvBuilder withBillingZip(String billingZip) {
		this.billingZip = billingZip;
		return this;
	}

	public OrderCsvBuilder withBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
		return this;
	}

	public OrderCsvBuilder withBillingCountryCode(String billingCountryCode) {
		this.billingCountryCode = billingCountryCode;
		return this;
	}

	public OrderCsvBuilder withLineitemName(String lineitemName) {
		this.lineitemName = lineitemName;
		return this;
	}

	public OrderCsvBuilder withLineitemVariantId(String lineitemVariantId) {
		this.lineitemVariantId = lineitemVariantId;
		return this;
	}

	public OrderCsvBuilder withLineitemQuantity(Integer lineitemQuantity) {
		this.lineitemQuantity = lineitemQuantity;
		return this;
	}

	public OrderCsvBuilder withLineitemPrice(String lineitemPrice) {
		this.lineitemPrice = lineitemPrice;
		return this;
	}

	public OrderCsvBuilder withLineitemVariantTitle(String lineitemVariantTitle) {
		this.lineitemVariantTitle = lineitemVariantTitle;
		return this;
	}

	public OrderCsvBuilder withLineitemCompareAtPrice(String lineitemCompareAtPrice) {
		this.lineitemCompareAtPrice = lineitemCompareAtPrice;
		return this;
	}

	public OrderCsvBuilder withLineitemSku(String lineitemSku) {
		this.lineitemSku = lineitemSku;
		return this;
	}

	public OrderCsvBuilder withLineitemRequiresShipping(Boolean lineitemRequiresShipping) {
		this.lineitemRequiresShipping = lineitemRequiresShipping;
		return this;
	}

	public OrderCsvBuilder withLineitemTaxable(Boolean lineitemTaxable) {
		this.lineitemTaxable = lineitemTaxable;
		return this;
	}

	public OrderCsvBuilder withLineitemFullfillmentStatus(String lineitemFullfillmentStatus) {
		this.lineitemFullfillmentStatus = lineitemFullfillmentStatus;
		return this;
	}

	public OrderCsvBuilder withTaxesIncluded(boolean taxesIncluded) {
		this.taxesIncluded = taxesIncluded;
		return this;
	}

	public OrderCsvBuilder withTax1Title(String tax1Title) {
		this.tax1Title = tax1Title;
		return this;
	}

	public OrderCsvBuilder withTax1Price(BigDecimal tax1Price) {
		this.tax1Price = tax1Price;
		return this;
	}

	public OrderCsvBuilder withTax1Rate(String tax1Rate) {
		this.tax1Rate = tax1Rate;
		return this;
	}

	public OrderCsvBuilder withTax2Title(String tax2Title) {
		this.tax2Title = tax2Title;
		return this;
	}

	public OrderCsvBuilder withTax2Price(BigDecimal tax2Price) {
		this.tax2Price = tax2Price;
		return this;
	}

	public OrderCsvBuilder withTax2Rate(String tax2Rate) {
		this.tax2Rate = tax2Rate;
		return this;
	}

	public OrderCsvBuilder withTax3Title(String tax3Title) {
		this.tax3Title = tax3Title;
		return this;
	}

	public OrderCsvBuilder withTax3Price(BigDecimal tax3Price) {
		this.tax3Price = tax3Price;
		return this;
	}

	public OrderCsvBuilder withTax3Rate(String tax3Rate) {
		this.tax3Rate = tax3Rate;
		return this;
	}

	public OrderCsvBuilder withTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
		return this;
	}

	public OrderCsvBuilder withTransactionKind(TransactionKind transactionKind) {
		this.transactionKind = transactionKind;
		return this;
	}

	public OrderCsvBuilder withTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
		return this;
	}

	public OrderCsvBuilder withTransactionProcessedAt(String transactionProcessedAt) {
		this.transactionProcessedAt = transactionProcessedAt;
		return this;
	}

	public OrderCsvBuilder withTransactionGateway(String transactionGateway) {
		this.transactionGateway = transactionGateway;
		return this;
	}

	public OrderCsvBuilder withTransactionLocationId(String transactionLocationId) {
		this.transactionLocationId = transactionLocationId;
		return this;
	}

	public OrderCsvBuilder withTransactionSourceName(String transactionSourceName) {
		this.transactionSourceName = transactionSourceName;
		return this;
	}

	public OrderCsvBuilder withShippingLineCode(String shippingLineCode) {
		this.shippingLineCode = shippingLineCode;
		return this;
	}

	public OrderCsvBuilder withShippingLinePrice(String shippingLinePrice) {
		this.shippingLinePrice = shippingLinePrice;
		return this;
	}

	public OrderCsvBuilder withShippingLineSource(String shippingLineSource) {
		this.shippingLineSource = shippingLineSource;
		return this;
	}

	public OrderCsvBuilder withShippingLineTitle(String shippingLineTitle) {
		this.shippingLineTitle = shippingLineTitle;
		return this;
	}

	public OrderCsvBuilder withShippingLineCarrierIdentifier(String shippingLineCarrierIdentifier) {
		this.shippingLineCarrierIdentifier = shippingLineCarrierIdentifier;
		return this;
	}

	public OrderCsvBuilder withShippingLineRequestedFullfillmentServiceId(String shippingLineRequestedFullfillmentServiceId) {
		this.shippingLineRequestedFullfillmentServiceId = shippingLineRequestedFullfillmentServiceId;
		return this;
	}

	public OrderCsvBuilder withShippingTax1Title(String shippingTax1Title) {
		this.shippingTax1Title = shippingTax1Title;
		return this;
	}

	public OrderCsvBuilder withShippingTax1Rate(BigDecimal shippingTax1Rate) {
		this.shippingTax1Rate = shippingTax1Rate;
		return this;
	}

	public OrderCsvBuilder withShippingTaxPrice(BigDecimal shippingTaxPrice) {
		this.shippingTaxPrice = shippingTaxPrice;
		return this;
	}

	public OrderCsvBuilder withDiscountCode(String discountCode) {
		this.discountCode = discountCode;
		return this;
	}

	public OrderCsvBuilder withDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
		return this;
	}

	public OrderCsvBuilder withDiscountType(DiscountType discountType) {
		this.discountType = discountType;
		return this;
	}

	public OrderCsvBuilder withMetafieldNamespace(String metafieldNamespace) {
		this.metafieldNamespace = metafieldNamespace;
		return this;
	}

	public OrderCsvBuilder withMetafieldKey(String metafieldKey) {
		this.metafieldKey = metafieldKey;
		return this;
	}

	public OrderCsvBuilder withMetafieldValue(String metafieldValue) {
		this.metafieldValue = metafieldValue;
		return this;
	}

	public OrderCsvBuilder withMetafieldValueType(String metafieldValueType) {
		this.metafieldValueType = metafieldValueType;
		return this;
	}

	public OrderCsv build() {
		return new OrderCsv(
				name,
				email,
				financialStatus,
				fulfillmentStatus,
				currency,
				buyerAcceptsMarketing,
				cancelReason,
				cancelledAt,
				tags,
				note,
				phone,
				referringSite,
				processedAt,
				sourcename,
				totalWeight,
				totalTax,
				shippingCompany,
				shippingName,
				shippingPhone,
				shippingFirstName,
				shippingLastName,
				shippingAddress1,
				shippingAddress2,
				shippingCity,
				shippingProvince,
				shippingProvinceCode,
				shippingZip,
				shippingCountry,
				shippingCountyCode,
				billingCompany,
				billingName,
				billingPhone,
				billingFirstName,
				billingLastName,
				billingAddress1,
				billingAddress2,
				billingCity,
				billingProvince,
				billingProvinceCode,
				billingZip,
				billingCountry,
				billingCountryCode,
				lineitemName,
				lineitemVariantId,
				lineitemQuantity,
				lineitemPrice,
				lineitemVariantTitle,
				lineitemCompareAtPrice,
				lineitemSku,
				lineitemRequiresShipping,
				lineitemTaxable,
				lineitemFullfillmentStatus,
				taxesIncluded,
				tax1Title,
				tax1Price,
				tax1Rate,
				tax2Title,
				tax2Price,
				tax2Rate,
				tax3Title,
				tax3Price,
				tax3Rate,
				transactionAmount,
				transactionKind,
				transactionStatus,
				transactionProcessedAt,
				transactionGateway,
				transactionLocationId,
				transactionSourceName,
				shippingLineCode,
				shippingLinePrice,
				shippingLineSource,
				shippingLineTitle,
				shippingLineCarrierIdentifier,
				shippingLineRequestedFullfillmentServiceId,
				shippingTax1Title,
				shippingTax1Rate,
				shippingTaxPrice,
				discountCode,
				discountAmount,
				discountType,
				metafieldNamespace,
				metafieldKey,
				metafieldValue,
				metafieldValueType);
	}
}
