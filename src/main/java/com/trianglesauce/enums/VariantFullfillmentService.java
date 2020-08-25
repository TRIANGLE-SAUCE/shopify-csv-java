package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VariantFullfillmentService {
	MANUAL("manual"),
	HANDLE_OF_THE_FULFILLMENT_SERVICE("handle of the fulfillment service");

	private final String code;

	VariantFullfillmentService(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
