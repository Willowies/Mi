package com.mi.model.bean;

public class LikeProduct {
	private int likeProductId;
	private Product product;
	private int userId;
	
	public int getLikeProductId() {
		return likeProductId;
	}
	public void setLikeProductId(int likeProductId) {
		this.likeProductId = likeProductId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
