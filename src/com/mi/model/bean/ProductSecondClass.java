package com.mi.model.bean;

public class ProductSecondClass {
	
	private int firstClassId;
	private int secondClassId;
	private String secondClassName;
	private ProductFirstClass firstClass;
	
	
	public ProductFirstClass getFirstClass() {
		return firstClass;
	}
	public void setFirstClass(ProductFirstClass firstClass) {
		this.firstClass = firstClass;
	}
	public int getFirstClassId() {
		return firstClassId;
	}
	public void setFirstClassId(int firstClassId) {
		this.firstClassId = firstClassId;
	}
	public int getSecondClassId() {
		return secondClassId;
	}
	public void setSecondClassId(int secondClassId) {
		this.secondClassId = secondClassId;
	}
	public String getSecondClassName() {
		return secondClassName;
	}
	public void setSecondClassName(String secondClassName) {
		this.secondClassName = secondClassName;
	}

	
	
}
