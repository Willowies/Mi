package com.mi.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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
		}
		return list;
	}
	public List<GroupProduct> getGroupProducts(){
		List<GroupProduct> list = groupProductDAO.getGroupProducts();
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
		return productDAO.getNavProducts(navColumnName);
	}
	public List<Product> getSecondClassProducts(){
		return productDAO.getSecondClassProducts();
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
	
}
