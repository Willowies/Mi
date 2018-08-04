package com.mi.model.dao;

import java.util.List;
import java.util.Map;

import com.mi.model.bean.Product;

public interface ProductDAO {
	
	public List<Product> getPhoneProducts();
	
	public List<Product> getApplianceProducts();
	
	public List<Product> getCollocationProducts();
	
	public List<Product> getNavProducts(String navColumnName);
	
	public List<Product> getSecondClassProducts();
	
	public List<Product> selectProductByName(String productName);
	
	public Product selectProduct(Map<String, Object> map);
	
	public List<Product> selectProductColor(Map<String, Object> map);
	
	public Product selectProductById(int productId);
	
}
