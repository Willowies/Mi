package com.mi.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.CartItem;
import com.mi.model.bean.GroupProduct;
import com.mi.model.dao.CartItemDAO;
import com.mi.model.dao.GroupProductDAO;

@Service
public class HomeService {
	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private GroupProductDAO groupProductDAO;
	
	public List<CartItem> getCartItems(int userId){
		return cartItemDAO.getCartItems(userId);
	}
	public List<GroupProduct> getGroupProducts(){
		return groupProductDAO.getGroupProducts();
	}
}
