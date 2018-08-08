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
		
		List<AsTable> tableList = asServiceDAO.getAllTables();//获取所有的申请单
		
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

	//通过sn去判断orderProduct里面有没有这个sn的订单
	public OrderProduct getOrderProBySn(Integer asSn) {
		return asServiceDAO.getOrderProBySn(asSn);
	}

	//根据订单ID得到所有的订单
	public List<Order> getAllOrder() {
		return asServiceDAO.getAllOrder();
	}

	/**
	 * 根据订单ID显示订单内的商品信息
	 * 通过订单ID得到orderProduct里面的记录
	 * 一个orderid对应多个orderproduct的记录
	 */
	public List<OrderProduct> getOrderProById(int orderId) {
		return asServiceDAO.getOrderProById(orderId);
	}

	public Product getProductById(int productId) {
		return asServiceDAO.getProductById(productId);
	}

	//自动改变申请表的状态，有正在审核，更新到已完成
	public void updateStateAuto(String asId) {
		asServiceDAO.updateStateAuto(asId);
	}

}
