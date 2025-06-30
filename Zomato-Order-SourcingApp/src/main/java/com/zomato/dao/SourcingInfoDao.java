package com.zomato.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zomato.entity.SourcingInfo;

@Repository
public interface SourcingInfoDao extends CrudRepository<SourcingInfo, String>{

	@Query("FROM com.zomato.entity.SourcingInfo")
	public abstract List<SourcingInfo> getSourcingList();
	
	public abstract List<SourcingInfo> findByIs3pFulfilled(Boolean is3pFulfilled);
}
