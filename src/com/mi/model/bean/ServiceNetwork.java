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
	private List<ServiceProduct> ServiceProducts;
	private List<ServiceType> ServiceTypes;
	
	public ServiceNetwork(int snId,String snName,String snCity,
	String snCountry,String snAddress,String snTelephone,String 
	snWorkTime,List<ServiceProduct> ServiceProducts,List<ServiceType> ServiceTypes){
		this.snId=snId;
		this.snName=snName;
		this.snCity=snCity;
		this.snCountry=snCountry;
		this.snAddress=snAddress;
		this.snTelephone=snTelephone;
		this.snWorkTime=snWorkTime;
		this.ServiceProducts=ServiceProducts;
		this.ServiceTypes=ServiceTypes;
		
		
	}
	public ServiceNetwork() {
		// TODO Auto-generated constructor stub
	}
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
		return ServiceProducts;
	}
	public void setServiceProducts(List<ServiceProduct> serviceProducts) {
		ServiceProducts = serviceProducts;
	}
	public List<ServiceType> getServiceTypes() {
		return ServiceTypes;
	}
	public void setServiceTypes(List<ServiceType> serviceTypes) {
		ServiceTypes = serviceTypes;
	}

}
