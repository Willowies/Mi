package com.mi.model.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.Group;
import com.mi.model.bean.GroupProduct;
import com.mi.model.bean.OrderProduct;
import com.mi.model.dao.GroupDAO;
import com.mi.model.dao.GroupProductDAO;
import com.mi.model.dao.OrderDAO;
import com.mi.model.dao.StockDAO;

@Service
public class GroupPurchaseService {
	@Autowired
	private GroupProductDAO groupProductDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private StockDAO stockDAO;
	
	public List<GroupProduct> getGroupProducts(){
		Date currentDate = new Date();
		List<GroupProduct> list = groupProductDAO.getAllGroupProducts(currentDate);
		for(int i=0;i<list.size();i++) {
			String extremeName = list.get(i).getProduct().getProductName();
			if(list.get(i).getProduct().getColor()!=null) {
				extremeName += " "+list.get(i).getProduct().getColor();
			}
			if(list.get(i).getProduct().getSize()!=null) {
				extremeName += " "+list.get(i).getProduct().getSize();
			}
			if(list.get(i).getProduct().getVersion()!=null) {
				extremeName += " "+list.get(i).getProduct().getVersion();
			}
			list.get(i).getProduct().setExtremeName(extremeName);
		}
		return list;
	}
	public GroupProduct getGroupProductById(int groupProductId) {
		return groupProductDAO.getGroupProductById(groupProductId);
	}
	public List<Group> getProductGroups(int groupProductId){
		return groupDAO.getProductGroups(groupProductId);
	}
	public int addGroup(int groupProductId, String userName) {
		//count up the total people in groups
		List<Group> list = groupDAO.getProductGroups(groupProductId);
		int totalNum = 0;
		if(list.size()!=0) {
			for(Group g:list) {
				totalNum += g.getCurrentQuantity();
			}
			int maxGroupProductNum = list.get(0).getGroupProduct().getMaxGroupProductNum();
			int leastGroupNum = list.get(0).getGroupProduct().getLeastGroupNum();
			if((maxGroupProductNum-totalNum)>=leastGroupNum) {
				//can create group
				groupDAO.addGroup(groupProductId, userName);
				return groupDAO.getGroupId(groupProductId, userName);
			}else {
				//can't create group
				return 0;
			}
		}else {
			//create first group
			groupDAO.addGroup(groupProductId, userName);
			return groupDAO.getGroupId(groupProductId, userName);
		}
	}
	public int getCurrentQuantity(int groupProductId) {
		//count up the total people in groups
		List<Group> list = groupDAO.getProductGroups(groupProductId);
		int totalNum = 0;
		if(list.size()!=0) {
			for(Group g:list) {
				totalNum += g.getCurrentQuantity();
			}
			int maxGroupProductNum = list.get(0).getGroupProduct().getMaxGroupProductNum();
			if(maxGroupProductNum > totalNum) {
				//can check "product Info" button
				return 1;
			}else {
				//can't check "product Info" button
				return 0;
			}
		}else {
			//can check "product Info" button
			return 1;
		}
	}
//	public void updateClearing(int groupProductId) {
//		//
//		List<Group> list = groupDAO.getProductGroups(groupProductId);
//		int totalNum = 0;
//		int leastGroupNum = list.get(0).getGroupProduct().getLeastGroupNum();
//		if(list.size()!=0) {
//			for(Group g:list) {
//				if(g.getCurrentQuantity() >= leastGroupNum) {
//					totalNum += g.getCurrentQuantity();
//					//group by group
//					orderDAO.updateClearingSuccessOrder(groupProductId, g.getGroupId());
//					stockDAO.updateClearingSuccessStock(groupProductId, g.getCurrentQuantity());
//				}else {
//					orderDAO.updateClearingFailOrder(g.getGroupId());
//					stockDAO.updateClearingFailStock(groupProductId, g.getCurrentQuantity());
//				}
//			}
//		}
//	}
	public OrderProduct getOrderProduct(int groupProductId) {
		GroupProduct temp = getGroupProductById(groupProductId);
		OrderProduct neededOP = new OrderProduct();
		neededOP.setProductPrice(temp.getGroupPrice());
		neededOP.setQuantity(1);
		neededOP.setProduct(temp.getProduct());
		neededOP.setAmount(temp.getGroupPrice());
		return neededOP;
	}
}




