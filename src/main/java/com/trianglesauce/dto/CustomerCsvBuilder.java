package com.trianglesauce.dto;

import com.trianglesauce.enums.AcceptsMarketing;
import com.trianglesauce.enums.MetafieldValueType;
import com.trianglesauce.enums.TaxExempt;

public class CustomerCsvBuilder {
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

    public CustomerCsvBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerCsvBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerCsvBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerCsvBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public CustomerCsvBuilder withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public CustomerCsvBuilder withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public CustomerCsvBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public CustomerCsvBuilder withProvince(String province) {
        this.province = province;
        return this;
    }

    public CustomerCsvBuilder withProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
        return this;
    }

    public CustomerCsvBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public CustomerCsvBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public CustomerCsvBuilder withZip(String zip) {
        this.zip = zip;
        return this;
    }

    public CustomerCsvBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerCsvBuilder withAcceptsMarketing(AcceptsMarketing acceptsMarketing) {
        this.acceptsMarketing = acceptsMarketing;
        return this;
    }

    public CustomerCsvBuilder withTags(String tags) {
        this.tags = tags;
        return this;
    }

    public CustomerCsvBuilder withNote(String note) {
        this.note = note;
        return this;
    }

    public CustomerCsvBuilder withTaxExempt(TaxExempt taxExempt) {
        this.taxExempt = taxExempt;
        return this;
    }

    public CustomerCsvBuilder withMetafieldNamespace(String metafieldNamespace) {
        this.metafieldNamespace = metafieldNamespace;
        return this;
    }

    public CustomerCsvBuilder withMetafieldKey(String metafieldKey) {
        this.metafieldKey = metafieldKey;
        return this;
    }

    public CustomerCsvBuilder withMetafieldValue(String metafieldValue) {
        this.metafieldValue = metafieldValue;
        return this;
    }

    public CustomerCsvBuilder withMetafieldValueType(MetafieldValueType metafieldValueType) {
        this.metafieldValueType = metafieldValueType;
        return this;
    }

    private boolean hasMetafield() {
        return metafieldKey != null || metafieldValue != null || metafieldValueType != null;
    }

    public CustomerCsv build() {
        return new CustomerCsv(
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
