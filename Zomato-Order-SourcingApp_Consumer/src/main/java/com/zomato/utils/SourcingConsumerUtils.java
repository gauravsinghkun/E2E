package com.zomato.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SourcingConsumerUtils {

	public String JsonToStringDeserealizer(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writeValueAsString(object);
		return writeValueAsString;
	}
}
