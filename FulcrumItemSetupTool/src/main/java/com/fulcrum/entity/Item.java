package com.fulcrum.entity;

import java.util.Arrays;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Item")
@Setter
@Getter
@ToString
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	private String itemType;
	private Character isTransactable;
	private String[] enabledStores;
	private String itemPrice;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Character getIsTransactable() {
		return isTransactable;
	}

	public void setIsTransactable(Character isTransactable) {
		this.isTransactable = isTransactable;
	}

	public String[] getEnabledStores() {
		return enabledStores;
	}

	public void setEnabledStores(String[] enabledStores) {
		this.enabledStores = enabledStores;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Item [itemType=" + itemType + ", isTransactable=" + isTransactable + ", enabledStores="
				+ Arrays.toString(enabledStores) + ", itemPrice=" + itemPrice + ", itemId=" + itemId + "]";
	}
}
