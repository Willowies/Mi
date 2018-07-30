package com.mi.model.bean;

import java.util.Date;

public class SpikeProduct {
	private int spikeProductId;
	private int productId;
	private String productName;
	private String version;
	private String color;	
	private String size;
	private String description;
	private float spikePrice;
	private float previousPrice;
	private Date startTime;
	private Date endTime;
	private int spikeQuantity;
	private int currentSpikeNum;
	private int spikeStatus;
	private String picUrl;
	private int stock;
	
	
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	

}
