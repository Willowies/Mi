package com.mi.model.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mi.model.bean.LikeProduct;
import com.mi.model.bean.Order;
import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.Product;
import com.mi.model.dao.LikeProductDAO;
import com.mi.model.dao.MessageDAO;
import com.mi.model.dao.OrderDAO;
import com.mi.model.dao.OrderZhouDAO;

@Service
public class LikeProductService {
	@Autowired
	private LikeProductDAO likeProductDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private OrderZhouDAO orderZhouDAO;
	@Autowired
	private OrderDAO orderDAO;
	
	public Map<String, Object> selectLikeProductByUserId(Integer userId,int pageNum,int pageSize){
		Page<LikeProduct> page = PageHelper.startPage(pageNum, pageSize);
		likeProductDAO.selectLikeProductByUserId(userId);
		List<LikeProduct> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());
		return map;
	}
	public int selectLikeProductCount(Integer userId){
		return likeProductDAO.selectLikeProductCount(userId);
	}
	public void deleteLikeProduct(Integer likeProductId){
		likeProductDAO.deleteLikeProduct(likeProductId);
	}
	public int selectUnpayOrderCount(int userId){
		return likeProductDAO.selectUnpayOrderCount(userId);
	}
	public int selectUncommentOrderCount(int userId){
		return likeProductDAO.selectUncommentOrderCount(userId);
	}
	public int selectPendingOrderCount(int userId){
		return likeProductDAO.selectPendingOrderCount(userId);
	}
	public Map<String, Object> selectClassfiedProductBySecondClassId(int secondClassId,int pageNum){
		Page<Product> page = PageHelper.startPage(pageNum, 5);
		likeProductDAO.selectClassfiedProductBySecondClassId(secondClassId);
		List<Product> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());
		return map;
	}
	public void addLogisticsMessage(int orderId){
		Order order = orderDAO.getOrderDetailsById(orderId);
		List<OrderProduct> products = order.getProducts();
		String messageTitle = "您编号为"+orderId+"的订单已经到货";
		String message = "您的订单：";
		int messageType = 3;
		String picUrl = products.get(0).getProduct().getPicUrl();
		int userId = order.getUser().getUserId();
		Date sendTime = new Date();
		
		int i = 0;
		for(OrderProduct oP :products){
			Product p = oP.getProduct();
			message = message+ p.getProductName();
			if(i==2){
				message = message + "...";
				break;
			}
			
			message = message + " ";
			i++;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("messageTitle",messageTitle);
		map.put("message",message);
		map.put("messageType",messageType);
		map.put("picUrl",picUrl);
		map.put("userId",userId);
		map.put("sendTime",sendTime);
		
		orderZhouDAO.updateOrderState(orderId, 3);
		messageDAO.addMessage(map);
	}
}
