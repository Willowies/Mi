package com.mi.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.ServiceNetwork;
import com.mi.model.bean.ServiceProduct;
import com.mi.model.dao.ServiceNetworkDAO;

@Service
public class ServiceNetworkService {
	@Autowired
	private ServiceNetworkDAO ServiceNetworkDAO;
	
	public List<ServiceNetwork> selectSN(String snCity,int secondClassId){
		return ServiceNetworkDAO.selectSN(snCity,secondClassId);
	}
	public List<ServiceProduct> selectAllServiceProducts(){
		return ServiceNetworkDAO.selectAllServiceProducts();
	}

}
