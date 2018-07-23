package com.mi.model.bean;

public class LikeProduct {
	private int likeProductId;
	private Product product;
	private User user;
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
