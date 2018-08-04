package com.mi.model.dao;

import java.util.List;

import com.mi.model.bean.CartItem;

public interface CartItemDAO {
	
	public List<CartItem> getCartItems(int userId);
	
	public void deleteCartItem(int cartItemId);
	
}
