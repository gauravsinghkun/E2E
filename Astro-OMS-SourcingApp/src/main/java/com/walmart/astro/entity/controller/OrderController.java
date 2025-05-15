package com.walmart.astro.entity.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.walmart.astro.entity.Order;
import com.walmart.astro.entity.exceptions.NoOrderExistException;
import com.walmart.astro.entity.exceptions.NoOrdersInDbException;
import com.walmart.astro.entity.service.OrderService;

@Controller
@ResponseBody
@RequestMapping("/api/v4/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping("/getOrderById/{Id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("Id") Integer orderId) {
		Order order = service.getOrderById(orderId);
		if(order==null)
			throw new NoOrderExistException("No order for order id :: "+orderId);
		return new ResponseEntity<Order>(order,HttpStatus.OK);
	}

	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> allOrders = service.getAllOrders();
		if(allOrders.isEmpty() || allOrders==null)
			throw new NoOrdersInDbException("No orders exist in DB");
		return new ResponseEntity<List<Order>>(allOrders,HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteOrder(@RequestBody Order order) {
		return new ResponseEntity<String>(service.deleteOrder(order),HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(service.saveOrder(order),HttpStatus.OK);
	}
}
