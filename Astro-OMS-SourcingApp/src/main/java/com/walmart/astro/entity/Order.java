package com.walmart.astro.entity;

import com.walmart.astro.entity.aspects.OrderAspects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Table(name = "`order`")
@Setter
@NoArgsConstructor
@ToString
public class Order {

	
	
	public void sample() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private String orderName;
	private String orderDescription;
	private Double orderPrice;
}
