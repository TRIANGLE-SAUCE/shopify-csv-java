package com.trianglesauce.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.trianglesauce.dto.Csv;
import com.trianglesauce.validator.CsvValidator;

import java.util.List;

public interface CsvFactory<T extends Csv> {

	CsvValidator<T> getValidator();

	CsvMapper getMapper();

	String create(List<T> csv) throws JsonProcessingException;
}
