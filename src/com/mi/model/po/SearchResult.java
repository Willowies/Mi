package com.mi.model.po;

import java.util.List;

import com.mi.model.bean.Comment;
import com.mi.model.bean.Product;

public class SearchResult {
	
	private String productName;
	private String productOriginalName;
	private float productPrice;
	private String picUrl;
	private int commentNum;
	private Comment comment;
	private List<Product> products;

	
	public String getProductOriginalName() {
		return productOriginalName;
	}

	public void setProductOriginalName(String productOriginalName) {
		this.productOriginalName = productOriginalName;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
