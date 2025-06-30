package com.walmart.astro.consumer.CustomResp;

import java.util.HashMap;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import com.walmart.astro.consumer.entity.Order;

@Component
public class ConsumerOrder {

	public static final String hostname = "http://localhost:9291/api/v4/order";

	public Order getOrderById(Integer orderId) {

		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("Id", orderId);
		WebClient webClient = WebClient.create();
		Order order = webClient.get().uri(hostname + "/getOrderById/{Id}", hashMap).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(Order.class).block();
		return order;
	}

	public List<Order> getAllOrders() {
		// If we want to use kafka in our project then we need to use subscribe instead of block method.
		WebClient webClient = WebClient.create();
		List<Order> list = webClient.get().uri(hostname + "/getAllOrders").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(List.class).block();
		return list;
	}

	public String deleteOrder(Order order) {

		WebClient webClient = WebClient.create();
		String string = webClient.post().uri(hostname + "/delete").body(BodyInserters.fromObject(order))
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
		return string;
	}

}
