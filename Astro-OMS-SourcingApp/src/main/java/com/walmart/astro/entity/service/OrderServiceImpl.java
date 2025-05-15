package com.walmart.astro.entity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.astro.entity.Order;
import com.walmart.astro.entity.ItemDao.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao dao;

	@Override
	public Order getOrderById(Integer orderId) {
		return dao.findById(orderId).get();
	}

	@Override
	public List<Order> getAllOrders() {
		Iterable<Order> all = dao.findAll();
		List<Order> arrayList = new ArrayList<>();
		for (Order order : all) {
			arrayList.add(order);
		}
		return arrayList;
	}

	@Override
	public String deleteOrder(Order order) {
		String result = "";
		dao.delete(order);
		result = "Order deleted for order-id :: " + order.getOrderId();
		return result;
	}

	@Override
	public Order saveOrder(Order order) {
		return dao.save(order);
	}

}
