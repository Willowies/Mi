package com.mi.model.dao;

import java.util.List;
import java.util.Map;

import com.mi.model.bean.Order;
import com.mi.model.bean.User;

public interface OrderDAO {

	public List<Order> getAllOrder(User user);
	
	public List<Order> getOrderByState(Map<String, Object> map);
	
	

}
