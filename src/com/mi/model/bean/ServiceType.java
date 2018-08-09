package com.mi.model.bean;

import java.util.List;

public class ServiceType {//服务类型实体类
	private int stId;
	private String stName;
	private List<ServiceNetwork> ServiceNetworks;
	
	public int getStId() {
		return stId;
		
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public List<ServiceNetwork> getServiceNetworks() {
		return ServiceNetworks;
	}
	public void setServiceNetworks(List<ServiceNetwork> serviceNetworks) {
		ServiceNetworks = serviceNetworks;
	}
	
	

}
