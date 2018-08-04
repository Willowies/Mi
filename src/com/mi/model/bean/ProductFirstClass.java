package com.mi.model.bean;

import java.util.List;

public class ProductFirstClass {
	
	private int firstClassId;
	private String firstClassName;
	private List<ProductSecondClass> secondClasses;
	
	
	
	public List<ProductSecondClass> getSecondClasses() {
		return secondClasses;
	}
	public void setSecondClasses(List<ProductSecondClass> secondClasses) {
		this.secondClasses = secondClasses;
	}
	public int getFirstClassId() {
		return firstClassId;
	}
	public void setFirstClassId(int firstClassId) {
		this.firstClassId = firstClassId;
	}
	public String getFirstClassName() {
		return firstClassName;
	}
	public void setFirstClassName(String firstClassName) {
		this.firstClassName = firstClassName;
	}
	
	
	
}
