package com.walmart.astro.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walmart.astro.consumer.CustomResp.ConsumerOrder;
import com.walmart.astro.consumer.entity.Order;

@Controller
@ResponseBody
@RequestMapping("/api/v4/orderConsumer")
public class OrderConsumerController {

	@Autowired
	private ConsumerOrder consumerOrder;
	
	@GetMapping("/getOrderById/{Id}")
	public ResponseEntity<Order> getOrderById(@RequestParam("Id") Integer orderId){
		return new ResponseEntity<Order>(consumerOrder.getOrderById(orderId),HttpStatus.OK);
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Order>> getAllOrders(){
		System.out.println("Consumer method is getting called");
		return new ResponseEntity<List<Order>>(consumerOrder.getAllOrders(),HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deleteOrder(@RequestBody Order order){
		return new ResponseEntity<String>(consumerOrder.deleteOrder(order),HttpStatus.OK);
	}
}
