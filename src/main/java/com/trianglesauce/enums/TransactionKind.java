package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionKind {
	AUTHORIZATION("authorization"),
	CAPTURE("capture"),
	SALE("sale"),
	VOID("void"),
	REFUND("refund");

	private final String code;

	TransactionKind(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
