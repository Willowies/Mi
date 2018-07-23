package com.mi.model.bean;

import java.util.Date;

public class Invoice {
	private int invoiceId;
	private int invoiceType;
	private int receiverType;
	private String content;
	private int taxNum;
	private String receivePhone;
	private String receiveEmail;
	private String receiver;
	private int orderId;
	
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(int invoiceType) {
		this.invoiceType = invoiceType;
	}
	public int getReceiverType() {
		return receiverType;
	}
	public void setReceiverType(int receiverType) {
		this.receiverType = receiverType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTaxNum() {
		return taxNum;
	}
	public void setTaxNum(int taxNum) {
		this.taxNum = taxNum;
	}
	public String getReceivePhone() {
		return receivePhone;
	}
	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}
	public String getReceiveEmail() {
		return receiveEmail;
	}
	public void setReceiveEmail(String receiveEmail) {
		this.receiveEmail = receiveEmail;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	private Date createDate;
}
