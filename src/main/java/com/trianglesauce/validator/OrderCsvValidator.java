package com.trianglesauce.validator;

import com.trianglesauce.dto.OrderCsv;
import com.trianglesauce.util.Assert;

public class OrderCsvValidator implements CsvValidator<OrderCsv> {

	private OrderCsvValidator() {}

	public static OrderCsvValidator getInstance() {
		return new OrderCsvValidator();
	}

	@Override
	public void validate(OrderCsv orderCsv) {
		Assert.notNull(orderCsv.getName(), "name must not be null.");

		validateEmail(orderCsv.getEmail(), "email is invalid format.");

		validateTax(orderCsv);

		validateTags(orderCsv.getTags());

		validateTransaction(orderCsv);

		// shipping province code
		if (orderCsv.getShippingProvince() != null) {
			Assert.notNull(orderCsv.getShippingProvinceCode(), "shipping province code must not be null.");
		}

		validateShippingLine(orderCsv);

		if (orderCsv.getLineitemQuantity() != null) {
			Assert.positive(orderCsv.getLineitemQuantity(), "lineitem quantity must be a positive number.");
		}

		// discount
		validateDiscount(orderCsv);

		// metafield
		validateMetafield(orderCsv);
	}

	private void validateTax(OrderCsv orderCsv) {
		if (orderCsv.getTotalTax() != null) {
			Assert.positive(orderCsv.getTotalTax(), "total tax must be a positive number.");
		}

		if (orderCsv.getTax1Price() != null || orderCsv.getTax2Price() != null || orderCsv.getTax3Price() != null) {
			throw new IllegalArgumentException("total tax must not be null.");
		}
		if (orderCsv.getShippingTaxPrice() != null) {
			throw new IllegalArgumentException("total tax must not be null.");
		}
	}

	private void validateTransaction(OrderCsv orderCsv) {
		if (orderCsv.getTransactionKind() != null) {
			return;
		}

		if (orderCsv.getTransactionAmount() != null
				|| orderCsv.getTransactionStatus() != null
				|| orderCsv.getTransactionProcessedAt() != null
				|| orderCsv.getTransactionGateway() != null
				|| orderCsv.getTransactionLocationId() != null
				|| orderCsv.getTransactionSourceName() != null) {
			throw new IllegalArgumentException("transaction kind must not be null.");
		}
	}

	private void validateDiscount(OrderCsv orderCsv) {
		if (orderCsv.getDiscountType() != null) {
			Assert.notNull(orderCsv.getDiscountCode(), "discount code must not be null.");
			Assert.notNull(orderCsv.getDiscountAmount(), "discount amount must not be null.");
		}
	}

	private void validateShippingLine(OrderCsv orderCsv) {
		Assert.notNull(orderCsv.getLineitemName(), "lineitem name must not be null.");

		if (orderCsv.getShippingLinePrice() != null) {
			Assert.notNull(orderCsv.getShippingLineTitle(), "shipping line title must not be null.");
		}
		if (orderCsv.getShippingLineTitle() != null) {
			Assert.notNull(orderCsv.getShippingLinePrice(), "shipping line price must not be null.");
		}
	}

	private void validateMetafield(OrderCsv orderCsv) {
		if (orderCsv.hasMetafield()) {
			Assert.notNull(orderCsv.getMetafieldKey(), "metafield key must not be null.");
			if (orderCsv.getMetafieldKey().length() > getMetafieldKeyLength()) {
				throw new IllegalArgumentException("metafield key must not be greater than " + getMetafieldKeyLength() + ".");
			}

			Assert.notNull(orderCsv.getMetafieldValue(), "metafield value must not be null.");
			Assert.notNull(orderCsv.getMetafieldValueType(), "metafield value type must not be null.");

			Assert.notNull(orderCsv.getMetafieldNamespace(), "metafield namespace must not be null");
			if (orderCsv.getMetafieldNamespace().length() > getMetafieldNamespaceLength()) {
				throw new IllegalArgumentException("metafield namespace must not be greater than " + getMetafieldNamespaceLength() + ".");
			}
		}
	}
}
