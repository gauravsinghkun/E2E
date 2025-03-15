package com.fulcrum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fulcrum.entity.Item;
import com.fulcrum.exception.ItemEntryException;
import com.fulcrum.exception.NoItemsExistInDbException;
import com.fulcrum.service.ItemService;

@Controller
@ResponseBody
@RequestMapping("/api/v2/item")
public class ItemController {

	@Autowired
	private ItemService service;

	@GetMapping("/getAllItems")
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> allItems = service.getAllItems();
		if (allItems.isEmpty())
			throw new NoItemsExistInDbException("No items exist in DB");
		return new ResponseEntity<List<Item>>(allItems, HttpStatus.OK);
	}

	@PostMapping("/saveItem")
	public ResponseEntity<Item> saveItem(@RequestBody Item item) {
		Item item2 = service.saveItem(item);
		if (item2 == null)
			throw new ItemEntryException("Item didn't saved");
		return new ResponseEntity<Item>(item2, HttpStatus.OK);
	}

	@GetMapping("/getItemmByTransactibility")
	public ResponseEntity<List<Item>> getItemmByTransactibility(@RequestParam Character isTransactable) {
		List<Item> list = service.findByIsTransactable(isTransactable);
		return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
	}

	@GetMapping("/getItemById/{itemId}")
	public ResponseEntity<Item> getItemById(@PathVariable Long itemId) {
		return new ResponseEntity<Item>(service.getItemById(itemId), HttpStatus.OK);
	}
}
