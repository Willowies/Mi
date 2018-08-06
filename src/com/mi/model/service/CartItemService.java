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
	
	//�����û����ﳵ����Ŀ
	public List<CartItem> findCartItem(int userId){
		//���Ҹÿͻ�����Ʒ
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
	
	//ɾ�����ﳵ��Ŀ
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
		//ͨ��id����CartItem
		CartItem cartItem = cartItemDAO.getItemById(cartItemId);
		if(num==1&&cartItem.getQuantity()==cartItem.getProduct().getMaxQuantity()){
			//��Ʒ��������޹�����
			return 1;
		}else if(num==-1&&cartItem.getQuantity()==1){
			//��Ʒ����Ϊ1
			return 2;
		}else{
			//��Ʒ�����޸�����
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("num", num);
			map.put("cartItemId", cartItemId);
			cartItemDAO.updateItemQuantity(map);
			return 3;
		}
	}
	
	public int addCartItem(int productId,int userId){
		//���ҹ��ﳵ���Ƿ��и���Ʒ
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("productId", productId);
		map1.put("userId", userId);
		CartItem c = cartItemDAO.getstate1ItemByPId(map1);
		if(c==null){
			//���ﳵ���޸���Ʒ
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
			//�ﵽ��Ʒ����޹�����
			return 2;
		}else{
			//���ﳵ���и���Ʒ��δ�ﵽ����޹�����
			Map<String,Object> map3 = new HashMap<String,Object>();
			map3.put("num", 1);
			map3.put("cartItemId",c.getCartItemId() );
			cartItemDAO.updateItemQuantity(map3);
			return 3;
		}
	}
	
	public List<Product> recommendProduct(){ 
		List<Product> products = cartItemDAO.recommendProduct();
		//������Ʒȫ��
		for(Product p:products){
			String name = p.getProductName()+" "+p.getColor()+" "+p.getVersion()+" "+p.getSize();
			String extremeName = name.replace("null", "");
			p.setExtremeName(extremeName);
		}
		return products;
	}
}
