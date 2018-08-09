package com.mi.model.bean;

import java.util.List;

public class ServiceNetwork {//服务网点实体类
	private int snId;
	private String snName;
	private String snCity;
	private String snCountry;
	private String snAddress;
	private String snTelephone;
	private String snWorkTime;
	private float snCoordx;
	private float snCoordy;
	private List<ServiceProduct> serviceProducts;
	private List<ServiceType> serviceTypes;
	
	
	public int getSnId() {
		
		return snId;
	}
	public void setSnId(int snId) {
		this.snId = snId;
	}
	public String getSnName() {
		return snName;
	}
	public void setSnName(String snName) {
		this.snName = snName;
	}
	public String getSnCity() {
		return snCity;
	}
	public void setSnCity(String snCity) {
		this.snCity = snCity;
	}
	public String getSnCountry() {
		return snCountry;
	}
	public void setSnCountry(String snCountry) {
		this.snCountry = snCountry;
	}
	public String getSnAddress() {
		return snAddress;
	}
	public void setSnAddress(String snAddress) {
		this.snAddress = snAddress;
	}
	public String getSnTelephone() {
		return snTelephone;
	}
	public void setSnTelephone(String snTelephone) {
		this.snTelephone = snTelephone;
	}
	public String getSnWorkTime() {
		return snWorkTime;
	}
	public void setSnWorkTime(String snWorkTime) {
		this.snWorkTime = snWorkTime;
	}
	public List<ServiceProduct> getServiceProducts() {
		return serviceProducts;
	}
	public void setServiceProducts(List<ServiceProduct> serviceProducts) {
		this.serviceProducts = serviceProducts;
	}
	public List<ServiceType> getServiceTypes() {
		return serviceTypes;
	}
	public void setServiceTypes(List<ServiceType> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}
	 public float getSnCoordx() {
			return snCoordx;
		}
		public void setSnCoordx(float snCoordx) {
			this.snCoordx = snCoordx;
		}
		public float getSnCoordy() {
			return snCoordy;
		}
		public void setSnCoordy(float snCoordy) {
			this.snCoordy = snCoordy;
		}

}
