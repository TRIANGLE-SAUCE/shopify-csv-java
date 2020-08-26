package com.trianglesauce.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.trianglesauce.dto.CustomerCsv;
import com.trianglesauce.util.Assert;
import com.trianglesauce.validator.CsvValidator;
import com.trianglesauce.validator.CustomerCsvValidator;

import java.util.List;

public class CustomerCsvFactory implements CsvFactory<CustomerCsv> {

	private final CsvValidator<CustomerCsv> validator;
	private final CsvMapper mapper;

	public CustomerCsvFactory() {
		this.validator = CustomerCsvValidator.getInstance();
		this.mapper = new CsvMapper();
	}

	public CustomerCsvFactory(CsvValidator<CustomerCsv> validator) {
		Assert.notNull(validator, "validator must not be null.");

		this.validator = validator;
		this.mapper = new CsvMapper();
	}

	@Override
	public CsvValidator<CustomerCsv> getValidator() {
		return this.validator;
	}

	@Override
	public CsvMapper getMapper() {
		return this.mapper;
	}

	@Override
	public String create(List<CustomerCsv> csv) throws JsonProcessingException {
		validate(csv);

		CsvSchema schema = getMapper().schemaFor(CustomerCsv.class).withHeader();
		return getMapper().writer(schema).writeValueAsString(csv);
	}

	private void validate(List<CustomerCsv> csv) {
		for (CustomerCsv row : csv) {
			getValidator().validate(row);
		}
	}
}
