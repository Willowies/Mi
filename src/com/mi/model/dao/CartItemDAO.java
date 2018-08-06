package com.mi.model.dao;

import java.util.List;
import java.util.Map;

import com.mi.model.bean.CartItem;
import com.mi.model.bean.Product;

public interface CartItemDAO {
	
	public List<CartItem> getCartItems(int userId);
	
	public void deleteCartItem(int cartItemId);
	
	//�����û����ﳵ����Ŀ
	public List<CartItem> findCartItem(int userId);
	//ɾ�����ﳵ��Ŀ
	public void deleteItem(int cartItemId);
	//ͨ��cartItemId���ҹ��ﳵ��Ŀ
	public CartItem getItemById(int cartItemId);
	//ͨ��productId��userId���ҹ��ﳵ��Ŀ
	public CartItem getItemByProductId(Map<String,Object> map);
	//ͨ��productId��userId����state=1�Ĺ��ﳵ��Ŀ
	public CartItem getstate1ItemByPId(Map<String,Object> map);
	//�޸Ĺ��ﳵ��Ŀ��Ʒ������
	public void updateItemQuantity(Map<String,Object> map);
	//���빺�ﳵ��Ŀ
	public void addCartItem(CartItem cartItem);
	//�����û����ﳵ����Ŀ
	//public List<CartItem> getCartItems(int userId);
	//���Ĺ��ﳵ��Ŀ״̬����Ϊ�ѽ���
	public void updateItemState(int cartItemId);
	//�Ƽ���Ʒ
	public List<Product> recommendProduct(); 
	
}
