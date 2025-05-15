package com.walmart.astro.entity.ItemDao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.walmart.astro.entity.Order;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer> {

}
