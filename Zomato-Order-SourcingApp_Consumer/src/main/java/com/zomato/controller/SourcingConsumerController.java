package com.zomato.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zomato.consumer.SourcingConsumer;
import com.zomato.entityModel.SourcingInfoModel;
import com.zomato.exception.NoSourcingListException;

@Controller
@ResponseBody
@RequestMapping("/api/v4/sourcing-consumer")
public class SourcingConsumerController {

	@Autowired
	private SourcingConsumer sourcingConsumer;

	@GetMapping("/getSourcingList")
	public ResponseEntity<List<SourcingInfoModel>> getSourcingList() throws NoSourcingListException {
		return new ResponseEntity<List<SourcingInfoModel>>(sourcingConsumer.getAllSourcingList(), HttpStatus.OK);
	}

	@GetMapping("/byFulfillment/{is3pFulfilled}")
	public ResponseEntity<List<SourcingInfoModel>> getSourcingByFulfillment(@PathVariable Boolean is3pFulfilled) {
		return new ResponseEntity<List<SourcingInfoModel>>(sourcingConsumer.findByIs3pFulfilled(is3pFulfilled),
				HttpStatus.OK);
	}

	@PostMapping("/getSourcingById/{uniqueSourcingId}")
	public ResponseEntity<SourcingInfoModel> getSourcingById(@PathVariable String uniqueSourcingId) {
		return new ResponseEntity<SourcingInfoModel>(sourcingConsumer.getSourcingById(uniqueSourcingId), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<SourcingInfoModel> saveSourcing(SourcingInfoModel sourcingInfoModel)
			throws JsonProcessingException {
		return new ResponseEntity<SourcingInfoModel>(sourcingConsumer.saveSourcingRRequest(sourcingInfoModel),
				HttpStatus.OK);
	}
}
