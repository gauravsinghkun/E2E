package com.fulcrum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fulcrum.entity.Item;

public interface ItemSetupDao extends CrudRepository<Item, Long> {

	@Query("from com.fulcrum.entity.Item")
	public List<Item> getAllItems();

	@Query("from com.fulcrum.entity.Item where itemId=:itemId")
	public Item getItemById(Long itemId);

	public abstract List<Item> findByIsTransactable(Character isTransactable);
}
