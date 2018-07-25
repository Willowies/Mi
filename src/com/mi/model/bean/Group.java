package com.mi.model.bean;

import java.util.List;

public class Group {
	private int groupId;
	private int productId;
	private List<User> groupMember;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public List<User> getGroupMember() {
		return groupMember;
	}
	public void setGroupMember(List<User> groupMember) {
		this.groupMember = groupMember;
	}
}
