package com.zomato.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zomato.dao.SourcingInfoDao;
import com.zomato.entity.SourcingInfo;

@Service
public class SourcingInfoServiceImpl implements SourcingInfoService {

	private SourcingInfoDao infoDao;

	public SourcingInfoServiceImpl() {
		System.out.println("SourcingInfoServiceImpl.SourcingInfoServiceImpl()");
	}

	@Autowired
	public SourcingInfoServiceImpl(SourcingInfoDao infoDao) {
		super();
		this.infoDao = infoDao;
		System.out.println("SourcingInfoServiceImpl.SourcingInfoServiceImpl()");
	}

	@Override
	public List<SourcingInfo> getSourcingList() {
		return infoDao.getSourcingList();
	}

	@Override
	public List<SourcingInfo> findByIs3pFulfilled(Boolean is3pFulfilled) {
		return infoDao.findByIs3pFulfilled(is3pFulfilled);
	}

	@Override
	public SourcingInfo getSourcingById(String sourcingUniqueId) {
		boolean existsById = infoDao.existsById(sourcingUniqueId);
		System.out.println(existsById);
		return infoDao.findById(sourcingUniqueId).get();
	}

	@Override
	public String deleteSourcingInfo(SourcingInfo info) {
		String result = "Deletion failed for id :: " + info.getSourcingUniqueId();
		boolean existsById = infoDao.existsById(info.getSourcingUniqueId());
		if (existsById) {
			infoDao.delete(info);
			result = "Sourcing deletion successful with id :: " + info.getSourcingUniqueId();
		}
		return result;
	}

	@Override
	public SourcingInfo updateSourcingInfo(SourcingInfo info) {
		infoDao.save(info);
		return info;
	}

	@Override
	public SourcingInfo save(SourcingInfo info) {
		return infoDao.save(info);
	}

}
