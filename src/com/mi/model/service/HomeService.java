package com.mi.model.service;

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
		return cartItemDAO.getCartItems(userId);
	}
	public List<GroupProduct> getGroupProducts(){
		return groupProductDAO.getGroupProducts();
	}
	public List<Product> getPhoneProducts(){
		return productDAO.getPhoneProducts();
	}
	public List<Product> getApplianceProducts(){
		return productDAO.getApplianceProducts();
	}
	public List<Product> getCollocationProducts(){
		return productDAO.getCollocationProducts();
	}
	public List<Product> getNavProducts(String navColumnName){
		return productDAO.getNavProducts(navColumnName);
	}
	public List<Product> getRecommendProducts(){
		return commentDAO.getRecommendProducts();
	}
	public List<Product> getPopularProducts(){
		return commentDAO.getPopularProducts();
	}
	public List<Product> getPopularProductsOfAppliance(){
		return commentDAO.getPopularProductsOfAppliance();
	}
	public List<Product> getPopularProductsOfCollocation(){
		return commentDAO.getPopularProductsOfCollocation();
	}
	
}
