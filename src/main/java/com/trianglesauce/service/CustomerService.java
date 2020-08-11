package com.trianglesauce.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trianglesauce.dto.CustomerDto;

public interface CustomerService {

	String createCsv(CustomerDto dto) throws JsonProcessingException;
}
