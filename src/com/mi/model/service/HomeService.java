package com.mi.model.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.CartItem;
import com.mi.model.bean.GroupProduct;
import com.mi.model.bean.Product;
import com.mi.model.dao.CartItemDAO;
import com.mi.model.dao.CommentDAO;
import com.mi.model.dao.GroupProductDAO;
import com.mi.model.dao.ProductDAO;

@Service
public class HomeService {
	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private GroupProductDAO groupProductDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CommentDAO commentDAO;
	
	public List<CartItem> getCartItems(int userId){
		List<CartItem> list = cartItemDAO.getCartItems(userId);
		for(int i=0;i<list.size();i++) {
			String extremeName = list.get(i).getProduct().getProductName();
			if(list.get(i).getProduct().getVersion()!=null) {
				extremeName += " "+list.get(i).getProduct().getVersion();
			}
			if(list.get(i).getProduct().getColor()!=null) {
				extremeName += " "+list.get(i).getProduct().getColor();
			}
			if(list.get(i).getProduct().getSize()!=null) {
				extremeName += " "+list.get(i).getProduct().getSize();
			}
			list.get(i).getProduct().setExtremeName(extremeName);
			//
			int quantity = list.get(i).getQuantity();
			float productPrice = list.get(i).getProduct().getProductPrice();
			list.get(i).setAmount(quantity*productPrice);
		}
		return list;
	}
	public List<GroupProduct> getGroupProducts() {
		Date currentDate = new Date();
		List<GroupProduct> list = groupProductDAO.getGroupProducts(currentDate);
		for(int i=0;i<list.size();i++) {
			String extremeName = list.get(i).getProduct().getProductName();
			if(list.get(i).getProduct().getVersion()!=null) {
				extremeName += " "+list.get(i).getProduct().getVersion();
			}
			if(list.get(i).getProduct().getColor()!=null) {
				extremeName += " "+list.get(i).getProduct().getColor();
			}
			if(list.get(i).getProduct().getSize()!=null) {
				extremeName += " "+list.get(i).getProduct().getSize();
			}
			list.get(i).getProduct().setExtremeName(extremeName);
		}
		return list;
	}
	public List<Product> getPhoneProducts(){
		List<Product> list = productDAO.getPhoneProducts();
		for(int i=0;i<list.size();i++) {
			String extremeName = list.get(i).getProductName();
			if(list.get(i).getVersion()!=null) {
				extremeName += " "+list.get(i).getVersion();
			}
			list.get(i).setExtremeName(extremeName);
		}
		return list;
	}
	public List<Product> getApplianceProducts(){
		List<Product> list = productDAO.getApplianceProducts();
		for(int i=0;i<list.size();i++) {
			String extremeName = list.get(i).getProductName();
			if(list.get(i).getSize()!=null) {
				extremeName += " "+list.get(i).getSize();
			}
			if(list.get(i).getVersion()!=null) {
				extremeName += " "+list.get(i).getVersion();
			}
			list.get(i).setExtremeName(extremeName);
		}
		return list;
	}
	public List<Product> getCollocationProducts(){
		List<Product> list = productDAO.getCollocationProducts();
		for(int i=0;i<list.size();i++) {
			String extremeName = list.get(i).getProductName();
			if(list.get(i).getColor()!=null) {
				extremeName += " "+list.get(i).getColor();
			}
			if(list.get(i).getSize()!=null) {
				extremeName += " "+list.get(i).getSize();
			}
			if(list.get(i).getVersion()!=null) {
				extremeName += " "+list.get(i).getVersion();
			}
			list.get(i).setExtremeName(extremeName);
		}
		return list;
	}
	public List<Product> getNavProducts(String navColumnName){
		String productType = "";
		int secondClassId = 0;
		switch (navColumnName) {
		case "小米手机":
			productType = "小米";
			secondClassId = 1;
			break;
		case "红米":
			productType = "红米";
			secondClassId = 1;
			break;
		case "电视":
			productType = "电视";
			secondClassId = 3;
			break;
		case "笔记本":
			productType = "笔记本";
			secondClassId = 4;
			break;
		default:
			productType = "小红电笔";
			secondClassId = 0;
			break;
		}
		return productDAO.getNavProducts(productType, secondClassId);
	}
	public List<Product> getSecondClassProducts(String categoryItemName){
		int categoryItemId = 0;
		switch (categoryItemName) {
		case "手机":
			categoryItemId=1;
			break;
		case "平板":
			categoryItemId=2;
			break;
		case "电视机":
			categoryItemId=3;
			break;
		case "笔记本":
			categoryItemId=4;
			break;
		case "空气净化器":
			categoryItemId=5;
			break;
		case "插线板":
			categoryItemId=6;
			break;
		default:
			categoryItemId=0;
			break;
		}
		return productDAO.getSecondClassProducts(categoryItemId);
	}
	public List<Product> getRecommendProducts(){
		List<Product> list = commentDAO.getRecommendProducts();
		for(int i=0;i<list.size();i++) {
			String extremeName = list.get(i).getProductName();
			if(list.get(i).getColor()!=null) {
				extremeName += " "+list.get(i).getColor();
			}
			if(list.get(i).getSize()!=null) {
				extremeName += " "+list.get(i).getSize();
			}
			if(list.get(i).getVersion()!=null) {
				extremeName += " "+list.get(i).getVersion();
			}
			list.get(i).setExtremeName(extremeName);
		}
		return list;
	}
	public List<Product> getPopularProducts(){
		return commentDAO.getPopularProducts();
	}
	public List<Product> getPopularProductsOfAppliance(){
		List<Product> list = commentDAO.getPopularProductsOfAppliance();
		for(int i=0;i<list.size();i++) {
			String extremeName = list.get(i).getProductName();
			if(list.get(i).getSize()!=null) {
				extremeName += " "+list.get(i).getSize();
			}
			if(list.get(i).getVersion()!=null) {
				extremeName += " "+list.get(i).getVersion();
			}
			list.get(i).setExtremeName(extremeName);
		}
		return list;
	}
	public List<Product> getPopularProductsOfCollocation(){
		List<Product> list = commentDAO.getPopularProductsOfCollocation();
		for(int i=0;i<list.size();i++) {
			String extremeName = list.get(i).getProductName();
			if(list.get(i).getColor()!=null) {
				extremeName += " "+list.get(i).getColor();
			}
			if(list.get(i).getSize()!=null) {
				extremeName += " "+list.get(i).getSize();
			}
			if(list.get(i).getVersion()!=null) {
				extremeName += " "+list.get(i).getVersion();
			}
			list.get(i).setExtremeName(extremeName);
		}
		return list;
	}
	public void deleteCartItem(int cartItemId) {
		cartItemDAO.deleteCartItem(cartItemId);
	}
	
}
