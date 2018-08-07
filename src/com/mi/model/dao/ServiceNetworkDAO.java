package com.mi.model.dao;

import java.util.List;

import com.mi.model.bean.ServiceNetwork;
import com.mi.model.bean.ServiceProduct;

public interface ServiceNetworkDAO {
	
	public List<ServiceNetwork> selectSN(String snCity,int secondClassId);
	public List<ServiceProduct> selectAllServiceProducts();

}
