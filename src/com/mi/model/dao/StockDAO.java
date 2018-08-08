package com.mi.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StockDAO {

	public int selectProductStock(int productId);
	
	public void updateClearingSuccessStock(@Param("groupProductId") int groupProductId, @Param("changeStock") int changeStock);
	
	public void updateClearingFailStock(@Param("groupProductId") int groupProductId, @Param("changeStock") int changeStock);
	
	public int selectStock(int productId);
	
	public void updateStock(Map<String,Object> map);
	
	public void updateSpikeStock(Map<String,Object> map);
	
	public void updateSpikeStock1(Map<String, Object> map);
}
