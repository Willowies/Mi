package com.mi.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.Product;

public interface ProductDAO {
	
	public List<Product> getPhoneProducts();
	
	public List<Product> getApplianceProducts();
	
	public List<Product> getCollocationProducts();
	
	public List<Product> getNavProducts(@Param("navColumnName") String navColumnName, @Param("secondClassId") int secondClassId);
	
	public List<Product> getSecondClassProducts(int secondClassProductId);
	
	public List<Product> selectProductByName(String productName);
	
	public Product selectProduct(Map<String, Object> map);
	
	public List<Product> selectProductColor(Map<String, Object> map);
	
	public Product selectProductById(int productId);
	
}
