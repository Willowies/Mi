package com.mi.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mi.model.bean.AsProInfo;
import com.mi.model.bean.AsTable;
import com.mi.model.bean.Order;
import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.Product;
import com.mi.model.dao.AsServiceDAO;

@Service
public class AsService {

	@Autowired AsServiceDAO asServiceDAO;
	
	public OrderProduct getProSn(int asSn) {
		// TODO Auto-generated method stub
		return asServiceDAO.getProSn(asSn);
	}

	public AsProInfo getProBySn(int asSn) {
		// TODO Auto-generated method stub
		return asServiceDAO.getProInfoBySn(asSn);
	}


	public void insertAsInfo(AsTable asTable) {
		asServiceDAO.insertAsInfo(asTable);
	}

	public PageInfo<AsTable> getAllTables(int pageNo,int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		
		List<AsTable> tableList = asServiceDAO.getAllTables();//��ȡ���е����뵥
		
		PageInfo<AsTable> pageInfo = new PageInfo<AsTable>(tableList);
		return pageInfo;
	}

	public AsTable getTableBySn(String asId) {
		return asServiceDAO.getTableBySn(asId);
	}

	public void updateState(String asId) {
		// TODO Auto-generated method stub
		asServiceDAO.updateState(asId);
	}

	//ͨ��snȥ�ж�orderProduct������û�����sn�Ķ���
	public OrderProduct getOrderProBySn(Integer asSn) {
		return asServiceDAO.getOrderProBySn(asSn);
	}

	//���ݶ���ID�õ����еĶ���
	public List<Order> getAllOrder() {
		return asServiceDAO.getAllOrder();
	}

	/**
	 * ���ݶ���ID��ʾ�����ڵ���Ʒ��Ϣ
	 * ͨ������ID�õ�orderProduct����ļ�¼
	 * һ��orderid��Ӧ���orderproduct�ļ�¼
	 */
	public List<OrderProduct> getOrderProById(int orderId) {
		return asServiceDAO.getOrderProById(orderId);
	}

	public Product getProductById(int productId) {
		return asServiceDAO.getProductById(productId);
	}

	//�Զ��ı�������״̬����������ˣ����µ������
	public void updateStateAuto(String asId) {
		asServiceDAO.updateStateAuto(asId);
	}

}
