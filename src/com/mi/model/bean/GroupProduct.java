package com.mi.model.bean;

import java.util.Date;
import java.util.Timer;

public class GroupProduct {
	private int groupProductId;
	private Product product;
	private float groupPrice;
	private int leastGroupNum;
	private int maxGroupProductNum;
	private Date beginDate;
	private Date endDate;
	private int stock;
	private Timer remainTime;
	
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getGroupProductId() {
		return groupProductId;
	}
	public void setGroupProductId(int groupProductId) {
		this.groupProductId = groupProductId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public float getGroupPrice() {
		return groupPrice;
	}
	public void setGroupPrice(float groupPrice) {
		this.groupPrice = groupPrice;
	}
	public int getLeastGroupNum() {
		return leastGroupNum;
	}
	public void setLeastGroupNum(int leastGroupNum) {
		this.leastGroupNum = leastGroupNum;
	}
	public int getMaxGroupProductNum() {
		return maxGroupProductNum;
	}
	public void setMaxGroupProductNum(int maxGroupProductNum) {
		this.maxGroupProductNum = maxGroupProductNum;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Timer getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(Timer remainTime) {
		this.remainTime = remainTime;
	}
}
