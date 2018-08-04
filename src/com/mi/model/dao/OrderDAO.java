package com.mi.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.Order;
import com.mi.model.bean.User;

public interface OrderDAO {

	public List<Order> getAllOrder(User user);
	
	public List<Order> getOrderByState(Map<String, Object> map);
	
	public List<Order> getAllGroupOrder(User user);
	
	public List<Order> getGroupOrderByState(Map<String, Object> map);

	public List<Order> getOrderByProductName(Map<String, Object> map);

	public Order getOrderDetailsById(int orderId);
	
	public void updateGroupInfo(int groupId, int userId);

	public void updateClearingSuccessOrder(@Param("groupProductId") int groupProductId, @Param("groupId") int groupId);
	
	public void updateClearingFailOrder(@Param("groupId") int groupId);
	
}
