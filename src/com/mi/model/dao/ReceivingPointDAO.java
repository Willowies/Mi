package com.mi.model.dao;

import java.util.List;

import com.mi.model.bean.ReceivingPoint;

public interface ReceivingPointDAO {
	
	public List<ReceivingPoint> selectRP(String city);

}
