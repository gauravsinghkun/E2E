package com.zomato.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class SourcingInfo {

	@Id
	private String sourcingUniqueId;
	@NonNull
	private String sourcingDetails;
	@NonNull
	private Integer sourcingAvailableInventoryCount;
	@NonNull
	private Boolean is3pFulfilled;

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean bool = false;
		SourcingInfo obj2 = (SourcingInfo) obj;
		if (obj2 == null)
			bool = false;
		if (this.getClass().equals(obj2.getClass()))
			bool = true;
		if (this.getSourcingUniqueId().equals(obj2.getSourcingUniqueId()))
			bool = true;
		return bool;
	}
}
