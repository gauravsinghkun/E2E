package com.walmart.astro.entity.service;

import java.util.List;

import com.walmart.astro.entity.Order;

public interface OrderService {

	public abstract Order getOrderById(Integer orderId);

	public abstract List<Order> getAllOrders();

	public abstract String deleteOrder(Order order);

	public abstract Order saveOrder(Order order);
}
