package com.mi.model.bean;

import java.util.List;

public class ServiceProduct {//�����Ʒʵ����
	private int spId;
	private String spName;
	private List<ServiceNetwork> ServiceNetworks;
	
	
	
	public ServiceProduct() {
		// TODO Auto-generated constructor stub
	}

	public List<ServiceNetwork> getServiceNetworks() {
		return ServiceNetworks;
	}
	public void setServiceNetworks(List<ServiceNetwork> serviceNetworks) {
		ServiceNetworks = serviceNetworks;
	}
	
	public int getSpId() {
		return spId;
	}
	public void setSpId(int spId) {
		this.spId = spId;
	}
	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	
	

}
