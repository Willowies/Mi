package com.mi.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.ReceivingPoint;
import com.mi.model.dao.ReceivingPointDAO;


@Service

public class ReceivingPointService {
	@Autowired
	private ReceivingPointDAO ReceivingPointDAO;
	
	public List<ReceivingPoint> selectRP(String city){
		return ReceivingPointDAO.selectRP(city);
	}

}
