package com.trianglesauce.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.trianglesauce.dto.CustomerDto;
import com.trianglesauce.service.CustomerService;
import com.trianglesauce.validator.CustomerDtoValidator;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public String createCsv(CustomerDto dto) throws JsonProcessingException {
		CustomerDtoValidator validator = CustomerDtoValidator.getInstance();
		validator.validate(dto);

		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(CustomerDto.class).withHeader();

		return mapper.writer(schema).writeValueAsString(dto);
	}
}
