package com.mi.model.dao;

import java.util.List;

import com.mi.model.bean.AsProInfo;
import com.mi.model.bean.AsTable;
import com.mi.model.bean.Order;
import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.Product;

public interface AsServiceDAO {

	public OrderProduct getProSn(int asSn);

	//ͨ�������sn���
	public AsProInfo getProInfoBySn(int asSn);

	//����һ���������ۺ�������Ϣ
	public void insertAsInfo(AsTable asTable);

	//������ݿ������еķ�������
	public List<AsTable> getAllTables();

	//����sn���һ�����񵥵�����
	public AsTable getTableBySn(String asId);

	//����asIdȥ�ı�һ�����񵥵�״̬
	public void updateState(String asId);

	public OrderProduct getOrderProBySn(Integer asSn);

	public List<Order> getAllOrder();

	public List<OrderProduct> getOrderProById(int orderId);

	public Product getProductById(int productId);

	public void updateStateAuto(String asId);
}
