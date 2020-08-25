package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PublishScope {
	WEB("web"),
	GLOBAL("global");

	private final String code;

	PublishScope(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
