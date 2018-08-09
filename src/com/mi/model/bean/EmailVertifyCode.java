package com.mi.model.bean;

public class EmailVertifyCode {
	private int emailVertifyCodeId;
	private int userId;
	private int vertifyCode;
	private int vertifyState;
	
	public int getEmailVertifyCodeId() {
		return emailVertifyCodeId;
	}
	public void setEmailVertifyCodeId(int emailVertifyCodeId) {
		this.emailVertifyCodeId = emailVertifyCodeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getVertifyCode() {
		return vertifyCode;
	}
	public void setVertifyCode(int vertifyCode) {
		this.vertifyCode = vertifyCode;
	}
	public int getVertifyState() {
		return vertifyState;
	}
	public void setVertifyState(int vertifyState) {
		this.vertifyState = vertifyState;
	}
}
