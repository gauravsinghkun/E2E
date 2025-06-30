package com.zomato.entityModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SourcingInfoModel {

	
	private String sourcingUniqueId;
	private String sourcingDetails;
	private Integer sourcingAvailableInventoryCount;
	private Boolean is3pFulfilled;
}
