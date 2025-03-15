package com.fulcrum.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fulcrum.dao.ItemSetupDao;
import com.fulcrum.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemSetupDao dao;

	@Override
	public List<Item> getAllItems() {
		return dao.getAllItems();
	}

	@Override
	public Item getItemById(Long itemId) {
		return dao.getItemById(itemId);
	}

	@Override
	public List<Item> findByIsTransactable(Character isTransactable) {
		return dao.findByIsTransactable(isTransactable);
	}

	@Override
	public Item saveItem(Item item) {
		return dao.save(item);
	}

}
