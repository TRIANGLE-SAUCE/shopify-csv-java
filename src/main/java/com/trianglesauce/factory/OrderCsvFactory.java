package com.trianglesauce.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.trianglesauce.dto.OrderCsv;
import com.trianglesauce.util.Assert;
import com.trianglesauce.validator.CsvValidator;
import com.trianglesauce.validator.OrderCsvValidator;

import java.util.List;

public class OrderCsvFactory implements CsvFactory<OrderCsv> {

	private final CsvValidator<OrderCsv> validator;
	private final CsvMapper mapper;

	public OrderCsvFactory() {
		this(OrderCsvValidator.getInstance(), new CsvMapper());
	}

	public OrderCsvFactory(CsvValidator<OrderCsv> validator) {
		this(validator, new CsvMapper());
	}

	private OrderCsvFactory(CsvValidator<OrderCsv> validator, CsvMapper mapper) {
		Assert.notNull(validator, "validator must not be null.");
		Assert.notNull(mapper, "mapper must not be null.");

		this.validator = validator;
		this.mapper = mapper;
	}

	@Override
	public CsvValidator<OrderCsv> getValidator() {
		return this.validator;
	}

	@Override
	public CsvMapper getMapper() {
		return this.mapper;
	}

	@Override
	public String create(List<OrderCsv> csv) throws JsonProcessingException {
		validate(csv);

		CsvSchema schema = getMapper().schemaFor(OrderCsv.class).withHeader();
		return getMapper().writer(schema).writeValueAsString(csv);
	}

	private void validate(List<OrderCsv> csv) {
		for (OrderCsv row : csv) {
			getValidator().validate(row);
		}
	}
}
