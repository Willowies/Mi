package com.mi.model.bean;

import java.util.Date;
import java.util.Timer;

public class GroupProduct {
	private int groupProductId;
	private Product product;
	private float groupProductPrice;
	private int leastGroupNum;
	private int maxGroupProductNum;
	private Date beginDate;
	private Date endDate;
	private Timer remainTime;
	
	public int getGroupProductId() {
		return groupProductId;
	}
	public void setGroupProductId(int groupProductId) {
		this.groupProductId = groupProductId;
	}
	public Product getProductId() {
		return product;
	}
	public void setProductId(Product product) {
		this.product = product;
	}
	public float getGroupProductPrice() {
		return groupProductPrice;
	}
	public void setGroupProductPrice(float groupProductPrice) {
		this.groupProductPrice = groupProductPrice;
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
