package com.trianglesauce.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.trianglesauce.dto.CustomerCsv;
import com.trianglesauce.service.CustomerService;
import com.trianglesauce.validator.CustomerCsvValidator;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public String createCsv(CustomerCsv customerCsv) throws JsonProcessingException {
		CustomerCsvValidator validator = CustomerCsvValidator.getInstance();
		validator.validate(customerCsv);

		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(CustomerCsv.class).withHeader();

		return mapper.writer(schema).writeValueAsString(customerCsv);
	}
}
