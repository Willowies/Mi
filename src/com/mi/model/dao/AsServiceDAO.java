package com.mi.model.dao;

import java.util.List;

import com.mi.model.bean.AsProInfo;
import com.mi.model.bean.AsTable;
import com.mi.model.bean.Order;
import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.Product;

public interface AsServiceDAO {

	public OrderProduct getProSn(int asSn);

	//通过输入的sn获得
	public AsProInfo getProInfoBySn(int asSn);

	//插入一个完整的售后服务表信息
	public void insertAsInfo(AsTable asTable);

	//获得数据库里所有的服务单数据
	public List<AsTable> getAllTables();

	//根据sn获得一个服务单的数据
	public AsTable getTableBySn(String asId);

	//根据asId去改变一个服务单的状态
	public void updateState(String asId);

	public OrderProduct getOrderProBySn(Integer asSn);

	public List<Order> getAllOrder();

	public List<OrderProduct> getOrderProById(int orderId);

	public Product getProductById(int productId);

	public void updateStateAuto(String asId);
}
