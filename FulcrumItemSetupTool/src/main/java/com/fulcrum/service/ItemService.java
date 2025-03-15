package com.fulcrum.service;

import java.util.List;
import com.fulcrum.entity.Item;

public interface ItemService {

	public List<Item> getAllItems();

	public Item getItemById(Long itemId);

	public abstract List<Item> findByIsTransactable(Character isTransactable);

	public Item saveItem(Item item);
}
