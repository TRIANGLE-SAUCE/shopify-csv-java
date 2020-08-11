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
public final class CustomerDto {
	@JsonProperty("First Name")
	private String firstName;
	@JsonProperty("Last Name")
	private String lastName;
	@JsonProperty("Email")
	private String email;
	@JsonProperty("Company")
	private String company;
	@JsonProperty("Address1")
	private String address1;
	@JsonProperty("Address2")
	private String address2;
	@JsonProperty("City")
	private String city;
	@JsonProperty("Province")
	private String province;
	@JsonProperty("Province Code")
	private String provinceCode;
	@JsonProperty("Country")
	private String country;
	@JsonProperty("Country Code")
	private String countryCode;
	@JsonProperty("Zip")
	private String zip;
	@JsonProperty("Phone")
	private String phone;
	@JsonProperty("Accepts Marketing")
	private AcceptsMarketing acceptsMarketing;
	@JsonProperty("Tags")
	private String tags;
	@JsonProperty("Note")
	private String note;
	@JsonProperty("Tax Exempt")
	private TaxExempt taxExempt;
	@JsonProperty("Metafield Namespace")
	private String metafieldNamespace;
	@JsonProperty("Metafield Key")
	private String metafieldKey;
	@JsonProperty("Metafield Value")
	private String metafieldValue;
	@JsonProperty("Metafield Value Type")
	private MetafieldValueType metafieldValueType;

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

	private CustomerDto() {}

	private CustomerDto(
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

	public static class CustomerDtoBuilder {
		private String firstName;
		private String lastName;
		private String email;
		private String company;
		private String address1;
		private String address2;
		private String city;
		private String province;
		private String provinceCode;
		private String country;
		private String countryCode;
		private String zip;
		private String phone;
		private AcceptsMarketing acceptsMarketing = AcceptsMarketing.NO;
		private String tags;
		private String note;
		private TaxExempt taxExempt = TaxExempt.NO;
		private String metafieldNamespace;
		private String metafieldKey;
		private String metafieldValue;
		private MetafieldValueType metafieldValueType;

		private CustomerDtoBuilder() {}

		public static CustomerDtoBuilder builder() {
			return new CustomerDtoBuilder();
		}

		public CustomerDtoBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public CustomerDtoBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public CustomerDtoBuilder email(String email) {
			this.email = email;
			return this;
		}

		public CustomerDtoBuilder company(String company) {
			this.company = company;
			return this;
		}

		public CustomerDtoBuilder address1(String address1) {
			this.address1 = address1;
			return this;
		}

		public CustomerDtoBuilder address2(String address2) {
			this.address2 = address2;
			return this;
		}

		public CustomerDtoBuilder city(String city) {
			this.city = city;
			return this;
		}

		public CustomerDtoBuilder province(String province) {
			this.province = province;
			return this;
		}

		public CustomerDtoBuilder provinceCode(String provinceCode) {
			this.provinceCode = provinceCode;
			return this;
		}

		public CustomerDtoBuilder country(String country) {
			this.country = country;
			return this;
		}

		public CustomerDtoBuilder countryCode(String countryCode) {
			this.countryCode = countryCode;
			return this;
		}

		public CustomerDtoBuilder zip(String zip) {
			this.zip = zip;
			return this;
		}

		public CustomerDtoBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public CustomerDtoBuilder acceptsMarketing(AcceptsMarketing acceptsMarketing) {
			this.acceptsMarketing = acceptsMarketing;
			return this;
		}

		public CustomerDtoBuilder tags(String tags) {
			this.tags = tags;
			return this;
		}

		public CustomerDtoBuilder note(String note) {
			this.note = note;
			return this;
		}

		public CustomerDtoBuilder taxExempt(TaxExempt taxExempt) {
			this.taxExempt = taxExempt;
			return this;
		}

		public CustomerDtoBuilder metafieldNamespace(String metafieldNamespace) {
			this.metafieldNamespace = metafieldNamespace;
			return this;
		}

		public CustomerDtoBuilder metafieldKey(String metafieldKey) {
			this.metafieldKey = metafieldKey;
			return this;
		}

		public CustomerDtoBuilder metafieldValue(String metafieldValue) {
			this.metafieldValue = metafieldValue;
			return this;
		}

		public CustomerDtoBuilder metafieldValueType(MetafieldValueType metafieldValueType) {
			this.metafieldValueType = metafieldValueType;
			return this;
		}

		private boolean hasMetafield() {
			return metafieldKey != null || metafieldValue != null || metafieldValueType != null;
		}

		public CustomerDto build() {
			return new CustomerDto(
					firstName,
					lastName,
					email,
					company,
					address1,
					address2,
					city,
					province,
					provinceCode,
					country,
					countryCode,
					zip,
					phone,
					acceptsMarketing,
					tags,
					note,
					taxExempt,
					metafieldNamespace == null && hasMetafield() ? "global" : metafieldNamespace,
					metafieldKey,
					metafieldValue,
					metafieldValueType);
		}
	}
}
