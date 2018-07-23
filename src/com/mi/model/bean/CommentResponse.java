package com.mi.model.bean;

import java.util.Date;

public class CommentResponse {
	
	private int commentResponseId;
	private int commentId;
	private int productId;
	private int userId;
	private String commentContent;
	private Date commentDate;
	public int getCommentResponseId() {
		return commentResponseId;
	}
	public void setCommentResponseId(int commentResponseId) {
		this.commentResponseId = commentResponseId;
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
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
	
	
}
