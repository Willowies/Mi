package com.mi.model.bean;

import java.util.List;

public class Group {
	private int groupId;
	private GroupProduct groupProduct;
	private String creator;
	private List<User> groupMember;
	private int currentQuantity;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public GroupProduct getGroupProduct() {
		return groupProduct;
	}
	public void setGroupProduct(GroupProduct groupProduct) {
		this.groupProduct = groupProduct;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public List<User> getGroupMember() {
		return groupMember;
	}
	public void setGroupMember(List<User> groupMember) {
		this.groupMember = groupMember;
	}
	public int getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
}
