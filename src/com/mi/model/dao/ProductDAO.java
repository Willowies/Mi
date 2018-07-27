package com.mi.model.dao;

import java.util.List;

import com.mi.model.bean.Product;

public interface ProductDAO {
	
	public List<Product> getPhoneProducts();
	
	public List<Product> getApplianceProducts();
	
	public List<Product> getCollocationProducts();
	
}
