package com.trianglesauce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trianglesauce.enums.AcceptsMarketing;
import com.trianglesauce.enums.MetafieldValueType;
import com.trianglesauce.enums.TaxExempt;

@JsonPropertyOrder({
		"First Name", "Last Name", "Email", "Company", "Address1",
		"Address2", "City", "Province", "Province Code", "Country",
		"Country Code", "Zip", "Phone", "Accepts Marketing", "Tags",
		"Note", "Tax Exempt", "Metafield Namespace", "Metafield Key", "Metafield Value",
		"Metafield Value Type"
})
public final class CustomerCsv implements Csv {
	@JsonProperty("First Name")
	private final  String firstName;
	@JsonProperty("Last Name")
	private final String lastName;
	@JsonProperty("Email")
	private final String email;
	@JsonProperty("Company")
	private final String company;
	@JsonProperty("Address1")
	private final String address1;
	@JsonProperty("Address2")
	private final String address2;
	@JsonProperty("City")
	private final String city;
	@JsonProperty("Province")
	private final String province;
	@JsonProperty("Province Code")
	private final String provinceCode;
	@JsonProperty("Country")
	private final String country;
	@JsonProperty("Country Code")
	private final String countryCode;
	@JsonProperty("Zip")
	private final String zip;
	@JsonProperty("Phone")
	private final String phone;
	@JsonProperty("Accepts Marketing")
	private final AcceptsMarketing acceptsMarketing;
	@JsonProperty("Tags")
	private final String tags;
	@JsonProperty("Note")
	private final String note;
	@JsonProperty("Tax Exempt")
	private final TaxExempt taxExempt;
	@JsonProperty("Metafield Namespace")
	private final String metafieldNamespace;
	@JsonProperty("Metafield Key")
	private final String metafieldKey;
	@JsonProperty("Metafield Value")
	private final String metafieldValue;
	@JsonProperty("Metafield Value Type")
	private final MetafieldValueType metafieldValueType;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public String getCountry() {
		return country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getZip() {
		return zip;
	}

	public String getPhone() {
		return phone;
	}

	public AcceptsMarketing getAcceptsMarketing() {
		return acceptsMarketing;
	}

	public String getTags() {
		return tags;
	}

	public String getNote() {
		return note;
	}

	public TaxExempt getTaxExempt() {
		return taxExempt;
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

	public MetafieldValueType getMetafieldValueType() {
		return metafieldValueType;
	}

	public boolean hasMetafield() {
		return getMetafieldNamespace() != null;
	}

	CustomerCsv(
			String firstName,
			String lastName,
			String email,
			String company,
			String address1,
			String address2,
			String city,
			String province,
			String provinceCode,
			String country,
			String countryCode,
			String zip,
			String phone,
			AcceptsMarketing acceptsMarketing,
			String tags,
			String note,
			TaxExempt taxExempt,
			String metafieldNamespace,
			String metafieldKey,
			String metafieldValue,
			MetafieldValueType metafieldValueType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.province = province;
		this.provinceCode = provinceCode;
		this.country = country;
		this.countryCode = countryCode;
		this.zip = zip;
		this.phone = phone;
		this.acceptsMarketing = acceptsMarketing;
		this.tags = tags;
		this.note = note;
		this.taxExempt = taxExempt;
		this.metafieldNamespace = metafieldNamespace;
		this.metafieldKey = metafieldKey;
		this.metafieldValue = metafieldValue;
		this.metafieldValueType = metafieldValueType;
	}
}
