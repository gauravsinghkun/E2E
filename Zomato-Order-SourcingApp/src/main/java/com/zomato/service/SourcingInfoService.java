package com.zomato.service;

import java.util.List;

import com.zomato.entity.SourcingInfo;

public interface SourcingInfoService {

	public abstract List<SourcingInfo> getSourcingList();

	public abstract List<SourcingInfo> findByIs3pFulfilled(Boolean is3pFulfilled);

	public abstract SourcingInfo getSourcingById(String sourcingUniqueId);

	public abstract String deleteSourcingInfo(SourcingInfo info);

	public abstract SourcingInfo updateSourcingInfo(SourcingInfo info);
	
	public abstract SourcingInfo save(SourcingInfo info);
}
