package com.mi.model.dao;

import java.util.Date;
import java.util.List;

import com.mi.model.bean.GroupProduct;

public interface GroupProductDAO {
	public List<GroupProduct> getGroupProducts(Date current);
	
	public List<GroupProduct> getAllGroupProducts(Date current);
	
	public GroupProduct getGroupProductById(int groupProductId);
}
