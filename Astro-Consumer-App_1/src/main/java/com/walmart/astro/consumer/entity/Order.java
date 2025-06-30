package com.walmart.astro.consumer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order {

	private Integer orderId;
	private String orderName;
	private String orderDescription;
	private Double orderPrice;
}
