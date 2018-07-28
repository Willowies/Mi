package com.mi.model.bean;

import java.util.Date;
import java.util.List;

public class Comment {
	
	private int commentId;
	private int productId;
	private int userId;
	private String commentContent;
	private int commentRank;
	private String commentUrl;
	private Date commentDate;
	private User user;
	private Product product;
	private List<CommentResponse> commentResponses;
	
	
	
	public List<CommentResponse> getCommentResponses() {
		return commentResponses;
	}
	public void setCommentResponses(List<CommentResponse> commentResponses) {
		this.commentResponses = commentResponses;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public int getCommentRank() {
		return commentRank;
	}
	public void setCommentRank(int commentRank) {
		this.commentRank = commentRank;
	}
	public String getCommentUrl() {
		return commentUrl;
	}
	public void setCommentUrl(String commentUrl) {
		this.commentUrl = commentUrl;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	

}
