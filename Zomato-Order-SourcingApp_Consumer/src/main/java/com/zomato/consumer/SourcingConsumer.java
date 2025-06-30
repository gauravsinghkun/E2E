package com.zomato.consumer;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.zomato.entityModel.SourcingInfoModel;
import com.zomato.exception.NoSourcingListException;
import com.zomato.utils.SourcingConsumerUtils;

@Component
public class SourcingConsumer {

	@Autowired
	private RestTemplate restTemplate;

	private static final String hostname = "http://localhost:8080/";
	private static final String patternPath = "/api/v4/mcse-sourcing";

	public List<SourcingInfoModel> getAllSourcingList() throws NoSourcingListException {
		String uri = "/getSourcingList";
		String url = hostname + patternPath + uri;
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
		if (!responseEntity.hasBody())
			throw new NoSourcingListException("No Sourcing List found in DB");
		@SuppressWarnings("unchecked")
		List<SourcingInfoModel> body = responseEntity.getBody();
		return body;
	}

	public List<SourcingInfoModel> findByIs3pFulfilled(Boolean is3pFulfilled) {
		String uri = "/findByIs3pFulfilled/{isFulfilled}";
		String url = hostname + patternPath + uri;
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("isFulfilled", is3pFulfilled);
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class, hashMap);
		@SuppressWarnings("unchecked")
		List<SourcingInfoModel> body = responseEntity.getBody();
		return body;
	}

	public SourcingInfoModel getSourcingById(String sourcingUniqueId) {
		String uri = "/getById/{sourcingId}";
		String url = hostname + patternPath + uri;
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("sourcingId", sourcingUniqueId);
		ResponseEntity<SourcingInfoModel> responseEntity = restTemplate.getForEntity(url, SourcingInfoModel.class,
				hashMap);
		return responseEntity.getBody();
	}

	public SourcingInfoModel saveSourcingRRequest(SourcingInfoModel info) throws JsonProcessingException {
		String uri = "/save";
		String url = hostname + patternPath + uri;
		SourcingConsumerUtils sourcingConsumerUtils = new SourcingConsumerUtils();
		String requestPayload = sourcingConsumerUtils.JsonToStringDeserealizer(info);
		HttpEntity<Object> httpEntity = new HttpEntity<>(requestPayload, null);
		ResponseEntity<SourcingInfoModel> responseEntity = restTemplate.postForEntity(url, httpEntity,SourcingInfoModel.class);
		return responseEntity.getBody();
	}
}
