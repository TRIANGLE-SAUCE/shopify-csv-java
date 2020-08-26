package com.trianglesauce.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.trianglesauce.dto.ProductCsv;
import com.trianglesauce.util.Assert;
import com.trianglesauce.validator.CsvValidator;
import com.trianglesauce.validator.ProductCsvValidator;

import java.util.List;

public class ProductCsvFactory implements CsvFactory<ProductCsv> {

	private final CsvValidator<ProductCsv> validator;
	private final CsvMapper mapper;

	public ProductCsvFactory() {
		this(ProductCsvValidator.getInstance(), new CsvMapper());
	}

	public ProductCsvFactory(CsvValidator<ProductCsv> validator) {
		this(validator, new CsvMapper());
	}

	private ProductCsvFactory(CsvValidator<ProductCsv> validator, CsvMapper mapper) {
		Assert.notNull(validator, "validator must not be null.");
		Assert.notNull(mapper, "mapper must not be null.");

		this.validator = validator;
		this.mapper = mapper;
	}

	@Override
	public CsvValidator<ProductCsv> getValidator() {
		return this.validator;
	}

	@Override
	public CsvMapper getMapper() {
		return this.mapper;
	}

	@Override
	public String create(List<ProductCsv> csv) throws JsonProcessingException {
		validate(csv);

		CsvSchema schema = getMapper().schemaFor(ProductCsv.class).withHeader();
		return getMapper().writer(schema).writeValueAsString(csv);
	}

	private void validate(List<ProductCsv> csv) {
		for (ProductCsv row : csv) {
			getValidator().validate(row);
		}
	}
}
