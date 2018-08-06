package com.mi.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.CartItem;
import com.mi.model.bean.Product;
import com.mi.model.dao.CartItemDAO;

@Service
public class CartItemService {
	@Autowired
	private CartItemDAO cartItemDAO;
	
	//查找用户购物车中条目
	public List<CartItem> findCartItem(int userId){
		//查找该客户的商品
		List<CartItem> list = cartItemDAO.findCartItem(userId);
		for(CartItem c:list){
			Product p = c.getProduct();
			float amount = p.getProductPrice()*c.getQuantity();
			c.setAmount(amount);
			String name = p.getProductName()+" "+p.getColor()+" "+p.getVersion()+" "+p.getSize();
			String extremeName = name.replace("null", "");
			c.getProduct().setExtremeName(extremeName);
		}
		return list;
	}
	
	//删除购物车条目
	public void deleteItem(int cartItemId){
		cartItemDAO.deleteItem(cartItemId);
	}
	
	
	public CartItem selectCartItem(int productId,int userId){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productId",productId);
		map.put("userId", userId);
		CartItem cartItem = cartItemDAO.getstate1ItemByPId(map);
		Product p = cartItem.getProduct();
		String name = p.getProductName()+" "+p.getColor()+" "+p.getVersion()+" "+p.getSize();
		String extremeName = name.replace("null", "");
		cartItem.getProduct().setExtremeName(extremeName);
		return cartItem;
	}
	
	public int updateItemQuantity(int num,int cartItemId){
		//通过id查找CartItem
		CartItem cartItem = cartItemDAO.getItemById(cartItemId);
		if(num==1&&cartItem.getQuantity()==cartItem.getProduct().getMaxQuantity()){
			//商品到达最大限购数量
			return 1;
		}else if(num==-1&&cartItem.getQuantity()==1){
			//商品数量为1
			return 2;
		}else{
			//商品可以修改数量
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("num", num);
			map.put("cartItemId", cartItemId);
			cartItemDAO.updateItemQuantity(map);
			return 3;
		}
	}
	
	public int addCartItem(int productId,int userId){
		//查找购物车中是否有该商品
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("productId", productId);
		map1.put("userId", userId);
		CartItem c = cartItemDAO.getstate1ItemByPId(map1);
		if(c==null){
			//购物车中无该商品
			CartItem cartItem = new CartItem();
			Product p = new Product();
			p.setProductId(productId);
			cartItem.setProduct(p);
			cartItem.setQuantity(1);
			cartItem.setState(1);
			cartItem.setUserId(userId);
			/*Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("cartItem", c);
			map2.put("productId", productId);*/
			cartItemDAO.addCartItem(cartItem);
			return 1;
		}else if(c.getQuantity()==c.getProduct().getMaxQuantity()){
			//达到商品最大限购数量
			return 2;
		}else{
			//购物车中有该商品且未达到最大限购数量
			Map<String,Object> map3 = new HashMap<String,Object>();
			map3.put("num", 1);
			map3.put("cartItemId",c.getCartItemId() );
			cartItemDAO.updateItemQuantity(map3);
			return 3;
		}
	}
	
	public List<Product> recommendProduct(){ 
		List<Product> products = cartItemDAO.recommendProduct();
		//设置商品全名
		for(Product p:products){
			String name = p.getProductName()+" "+p.getColor()+" "+p.getVersion()+" "+p.getSize();
			String extremeName = name.replace("null", "");
			p.setExtremeName(extremeName);
		}
		return products;
	}
}
