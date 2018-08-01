package com.mi.model.dao;

import org.apache.ibatis.annotations.Param;

public interface StockDAO {

	public int selectProductStock(int productId);

	public void updateClearingSuccessOrder(@Param("groupProductId") int groupProductId, @Param("groupId") int groupId);
	
	public void updateClearingSuccessStock(@Param("groupProductId") int groupProductId, @Param("changeStock") int changeStock);
	
	public void updateClearingFailOrder(@Param("groupProductId") int groupProductId, @Param("groupId") int groupId);
	
	public void updateClearingFailStock(@Param("groupProductId") int groupProductId, @Param("changeStock") int changeStock);
	
}
