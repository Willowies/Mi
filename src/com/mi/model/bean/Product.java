package com.mi.model.bean;

public class Product {
	private int productId;
	private String productName;
	private String extremeName;
	private float productPrice;
	private String description;
	private String color;
	private String version;
	private String size;
	private String picUrl;
	private Coupon coupon;
	private int maxQuantity;
	private int productCommentNum;
	private int secondClassId;
	private Comment comment;
	private int stock;
	private ProductSecondClass secondClass;
	private int likeProduct;
	
	
	
	public int getLikeProduct() {
		return likeProduct;
	}
	public void setLikeProduct(int likeProduct) {
		this.likeProduct = likeProduct;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public ProductSecondClass getSecondClass() {
		return secondClass;
	}
	public void setSecondClass(ProductSecondClass secondClass) {
		this.secondClass = secondClass;
	}
	public int getProductCommentNum() {
		return productCommentNum;
	}
	public void setProductCommentNum(int productCommentNum) {
		this.productCommentNum = productCommentNum;
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
	public String getExtremeName() {
		return extremeName;
	}
	public void setExtremeName(String extremeName) {
		this.extremeName = extremeName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	public int getSecondClassId() {
		return secondClassId;
	}
	public void setSecondClassId(int secondClassId) {
		this.secondClassId = secondClassId;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
