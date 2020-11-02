package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum  FinancialStatus {
	PENDING("pending"),
	AUTHORIZED("authorized"),
	PARTIALLY_PAID("partially_paid"),
	PAID("paid"),
	PARTIALLY_REFUNDED("partially_refunded"),
	REFUNDED("refunded"),
	VOIDED("voided");

	private final String code;

	FinancialStatus(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
