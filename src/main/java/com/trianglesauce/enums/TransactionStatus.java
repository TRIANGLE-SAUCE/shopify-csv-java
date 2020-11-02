package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionStatus {
	SUCCESS("success"),
	PENDING("pending"),
	FAILURE("failure"),
	ERROR("error");

	private final String code;

	TransactionStatus(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
