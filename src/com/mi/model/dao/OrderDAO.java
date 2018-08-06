package com.mi.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.Order;
import com.mi.model.bean.SpikeProduct;
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
	
	public int createOrder(Order order);
	
	public void addOrderProduct(Map<String,Object> map);
	
	public int selectOrderId();
	
	public int selectOrderItemId();
	
	public void updatePayOrder(int orderId);
	
	public void closePayOrder(int orderId);
	
	public void addGroupOrderProduct(Map<String,Object> map);
	
	public void updatePayGroupOrder(int orderId);
	
	public void updateGroup(int groupId);
	
	public SpikeProduct getSpikeProduct(int spikeProductId);
	
	public void updateSpikeProduct(int spikeProductId);
	
}
