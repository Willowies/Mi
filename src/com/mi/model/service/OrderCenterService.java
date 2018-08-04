package com.mi.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mi.model.bean.Order;
import com.mi.model.bean.User;
import com.mi.model.dao.OrderDAO;

@Service
public class OrderCenterService {

	@Autowired
	private OrderDAO orderDAO;

	public Map<String, Object> getAllOrder(User user, int pageNum, int pageSize) {
		Page<Order> page = PageHelper.startPage(pageNum, pageSize);
		List<Order> os = orderDAO.getAllOrder(user);
		List<Order> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());
		System.out.println("size:"+list.size()+" size:"+os.size());
		return map;
	}
	
	public Map<String, Object> getOrderByState(User user, int pageNum, int pageSize , int state) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("user", user);
		m.put("orderState", state);
		Page<Order> page = PageHelper.startPage(pageNum, pageSize);
		orderDAO.getOrderByState(m);
		List<Order> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());

		return map;
	}
	
	public Map<String, Object> getAllGroupOrder(User user, int pageNum, int pageSize) {
		Page<Order> page = PageHelper.startPage(pageNum, pageSize);
		orderDAO.getAllGroupOrder(user);
		List<Order> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());

		return map;
	}

	public Map<String, Object> getGroupOrderByState(User user, int pageNum, int pageSize , int state) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("user", user);
		m.put("orderState", state);
		Page<Order> page = PageHelper.startPage(pageNum, pageSize);
		orderDAO.getGroupOrderByState(m);
		List<Order> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());

		return map;
	}

	public Map<String, Object> getOrderByProductName(User user, int type, String productName, int pageNum, int pageSize) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("user", user);
		m.put("productName", productName);
		m.put("type", type);
		Page<Order> page = PageHelper.startPage(pageNum, pageSize);
		orderDAO.getOrderByProductName(m);
		List<Order> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());

		return map;
	}

	public Order getOrderDetailsById(Integer orderId) {
		
		return orderDAO.getOrderDetailsById(orderId);
	}

}
