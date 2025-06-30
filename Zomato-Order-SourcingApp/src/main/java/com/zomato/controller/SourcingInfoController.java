package com.zomato.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zomato.entity.SourcingInfo;
import com.zomato.errorClass.ErrorClass;
import com.zomato.exception.ItemFulfillmentException;
import com.zomato.exception.NoSourcingEventsException;
import com.zomato.service.SourcingInfoService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Controller
@ResponseBody
@RequestMapping("/api/v4/mcse-sourcing")
public class SourcingInfoController {

	private SourcingInfoService service;

	public SourcingInfoController() {
		System.out.println("SourcingInfoController.SourcingInfoController()");
	}

	@Autowired
	public SourcingInfoController(SourcingInfoService service) {
		super();
		this.service = service;
		System.out.println("SourcingInfoController.SourcingInfoController()");
	}

	@GetMapping("/getSourcingList")
	public ResponseEntity<List<SourcingInfo>> getSourcingList() throws NoSourcingEventsException {
		List<SourcingInfo> sourcingList = service.getSourcingList();
		if (sourcingList.isEmpty())
			throw new NoSourcingEventsException("No sourcing events present in SourcingDB");
		ResponseEntity<List<SourcingInfo>> responseEntity = new ResponseEntity<List<SourcingInfo>>(sourcingList,
				HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/findByIs3pFulfilled/{isFulfilled}")
	public ResponseEntity<List<SourcingInfo>> findByIs3pFulfilled(@PathVariable("isFulfilled") Boolean is3pFulfilled)
			throws ItemFulfillmentException {
		List<SourcingInfo> byIs3pFulfilledList = service.findByIs3pFulfilled(is3pFulfilled);
		if (byIs3pFulfilledList.isEmpty())
			throw new ItemFulfillmentException("No Evennts sourced for " + is3pFulfilled);
		ResponseEntity<List<SourcingInfo>> responseEntity = new ResponseEntity<List<SourcingInfo>>(byIs3pFulfilledList,
				HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/getById/{sourcingId}")
	public ResponseEntity<SourcingInfo> getSourcingById(@PathVariable("sourcingId") String sourcingUniqueId) {
		return new ResponseEntity<SourcingInfo>(service.getSourcingById(sourcingUniqueId), HttpStatus.OK);
	}

	@PostMapping("/delete")
	public String deleteSourcing(@RequestBody SourcingInfo info) {
		return service.deleteSourcingInfo(info);
	}

	@PostMapping("/save")
	@CircuitBreaker(name = "saveSourcingRequest" , fallbackMethod = "circuitBreakerHandler")
	@Retry(name = "saveSourcingRequest")
	public ResponseEntity<SourcingInfo> saveSourcingRRequest(@RequestBody SourcingInfo info) {
		return new ResponseEntity<SourcingInfo>(service.save(info), HttpStatus.OK);
	}
	
	public ResponseEntity<ErrorClass> circuitBreakerHandler(){
		return new ResponseEntity<ErrorClass>(new ErrorClass(100121, " Test Resilience-4j circuit breaker handler"),HttpStatus.OK);
	} 
}