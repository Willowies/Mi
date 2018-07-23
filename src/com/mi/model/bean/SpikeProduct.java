package com.mi.model.bean;

import java.util.Date;

public class SpikeProduct {
	private int spikeProductId;
	private int productId;
	private String productName;
	private float spikePrice;
	private float previousPrice;
	private Date spikeTime;
	private int duringTime;
	private int spikeQuantity;
	private int currentSpikeNum;
	private int spikeStatus;
	private String picUrl;
	
	public int getSpikeProductId() {
		return spikeProductId;
	}
	public void setSpikeProductId(int spikeProductId) {
		this.spikeProductId = spikeProductId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getSpikePrice() {
		return spikePrice;
	}
	public void setSpikePrice(float spikePrice) {
		this.spikePrice = spikePrice;
	}
	public float getPreviousPrice() {
		return previousPrice;
	}
	public void setPreviousPrice(float previousPrice) {
		this.previousPrice = previousPrice;
	}
	public Date getSpikeTime() {
		return spikeTime;
	}
	public void setSpikeTime(Date spikeTime) {
		this.spikeTime = spikeTime;
	}
	public int getDuringTime() {
		return duringTime;
	}
	public void setDuringTime(int duringTime) {
		this.duringTime = duringTime;
	}
	public int getSpikeQuantity() {
		return spikeQuantity;
	}
	public void setSpikeQuantity(int spikeQuantity) {
		this.spikeQuantity = spikeQuantity;
	}
	public int getCurrentSpikeNum() {
		return currentSpikeNum;
	}
	public void setCurrentSpikeNum(int currentSpikeNum) {
		this.currentSpikeNum = currentSpikeNum;
	}
	public int getSpikeStatus() {
		return spikeStatus;
	}
	public void setSpikeStatus(int spikeStatus) {
		this.spikeStatus = spikeStatus;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	

}
