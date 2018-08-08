package com.mi.model.dao;

import org.apache.ibatis.annotations.Param;

public interface OrderZhouDAO {
	public void updateOrderState(@Param(value = "orderId")Integer orderId,@Param(value = "orderState")Integer orderState);
}
