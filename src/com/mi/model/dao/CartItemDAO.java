package com.mi.model.dao;

import java.util.List;
import java.util.Map;

import com.mi.model.bean.CartItem;
import com.mi.model.bean.Product;

public interface CartItemDAO {
	
	public List<CartItem> getCartItems(int userId);
	
	public void deleteCartItem(int cartItemId);
	
	//查找用户购物车中条目
	public List<CartItem> findCartItem(int userId);
	//删除购物车条目
	public void deleteItem(int cartItemId);
	//通过cartItemId查找购物车条目
	public CartItem getItemById(int cartItemId);
	//通过productId和userId查找购物车条目
	public CartItem getItemByProductId(Map<String,Object> map);
	//通过productId和userId查找state=1的购物车条目
	public CartItem getstate1ItemByPId(Map<String,Object> map);
	//修改购物车条目商品的数量
	public void updateItemQuantity(Map<String,Object> map);
	//加入购物车条目
	public void addCartItem(CartItem cartItem);
	//查找用户购物车中条目
	//public List<CartItem> getCartItems(int userId);
	//更改购物车条目状态，置为已结算
	public void updateItemState(int cartItemId);
	//推荐商品
	public List<Product> recommendProduct(); 
	
}
