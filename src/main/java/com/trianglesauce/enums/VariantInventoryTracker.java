package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VariantInventoryTracker {
	SHOPIFY("Shopify"),
	FULFILLMENT_SERVICE_HANDLE("fulfillment-service-handle");

	private final String code;

	VariantInventoryTracker(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
