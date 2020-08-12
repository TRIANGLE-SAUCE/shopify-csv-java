package com.trianglesauce.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trianglesauce.dto.CustomerCsv;

public interface CustomerService {

	String createCsv(CustomerCsv customerCsv) throws JsonProcessingException;
}
