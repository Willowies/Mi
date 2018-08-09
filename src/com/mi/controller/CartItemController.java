package com.mi.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mi.model.bean.CartItem;
import com.mi.model.bean.Coupon;
import com.mi.model.bean.Product;
import com.mi.model.bean.ReceiverAddress;
import com.mi.model.bean.User;
import com.mi.model.dao.CartItemDAO;
import com.mi.model.service.CartItemService;
import com.mi.model.service.HomeService;
import com.mi.utils.BaseController;

@Controller
@RequestMapping("mi")
public class CartItemController extends BaseController{
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private HomeService homeService;
	@Autowired
	private ProductInfoController p;
	
	//��ɾ����session�м���userId
	@RequestMapping("addUserId")
	public String addUserId(int userId,HttpSession session){
		User user = new User();
		user.setUserId(userId);
		session.setAttribute("user", user);
		return "gotoCart";
	}
	
	
	@RequestMapping("findCartItem")
	public String findCartItem(Model model,HttpSession session){
		User user = (User)session.getAttribute("user");
		List<CartItem> list = cartItemService.findCartItem(user.getUserId());
		model.addAttribute("resultList",list);
		List<Product> products = homeService.getRecommendProducts();
		model.addAttribute("recommendProduct", products);
		System.out.println("������Ƽ���Ʒ�����Ƽ���Ʒ������Ϊ"+products.size());
		return "cart";
	}
	
	@RequestMapping("deleteItem")
	public String deleteItem(int cartItemId){
		cartItemService.deleteItem(cartItemId);
		return "redirect:findCartItem.action";
	}
	
	@RequestMapping("updateItemQuantity")
	public String updateItemQuantity(int num,int cartItemId,Model model){
		System.out.println("����updateItemQuantity����");
		int result = cartItemService.updateItemQuantity(num, cartItemId);
		if(result==1){
			//�ﵽ��Ʒ�����������
			model.addAttribute("message", "��Ʒ�ѵ�������޹�����");
		}else if(result==2){
			//��Ʒ����Ϊ1
			
		}else{
			
		}
		return "forward:findCartItem.action";
	}
	
	@RequestMapping("addCartItem")
	public String addCartItem(String productIdString,String productName,HttpSession session,Model model){
		System.out.println("����������Ʒ��Ϊ"+productName);
		User user = (User)session.getAttribute("user");
		int productId = Integer.parseInt(productIdString);
		int result = cartItemService.addCartItem(productId,user.getUserId());
		if(result==2){
			//�ﵽ��Ʒ����޹�����
			//model.addAttribute("productName",productName);
			//model.addAttribute("message", "��Ʒ�ѵ�������޹�����");
			model.addAttribute("message", "��Ʒ�ѵ�������޹�����");
			System.out.println("Ҫ����ȥ����Ʒ��Ϊ"+productName);
			System.out.println(productName);
			return p.selectProductInfo(model, productName, session);
		}else {
			//δ�ﵽ��Ʒ����޹�����
			//���ﳵ���и���Ʒ��δ�ﵽ����޹�����
			CartItem cartItem = cartItemService.selectCartItem(productId,user.getUserId());
			model.addAttribute("cartItem", cartItem);
			//model.addAttribute("message", "��Ʒ�Ѽ��빺�ﳵ");
			List<Product> products = homeService.getRecommendProducts();
			model.addAttribute("recommendProduct", products);
			return "addToCart";
		}
	}
	
	@RequestMapping("recommendProduct")
	public String recommendProduct(Model model){
		List<Product> products = cartItemService.recommendProduct();
		model.addAttribute("products", products);
		return "gotoCart";
	}
	
	@RequestMapping("displayProductSummary")
	public String displayProductSummary(String productName){
		System.out.println("productName��ֵΪ"+productName);
		System.out.println(productName);
		if(productName.equals("С��8")){
			return "xiaomi8";
		}else if(productName.equals("С��ƽ��4")){
			return "miPad4";
		}else if(productName.equals("С�׵���4")){
			return "TV4";
		}else if(productName.equals("����note5")){
			return "miNote5";
		}else if(productName.equals("С����Ϸ��")){
			return "gameBook";
		}else if(productName.equals("�׼ҿ���������Pro")){
			return "airClean";
		}else if(productName.equals("С��6X ���򱣻���")){
			return "mi6X";
		}else if(productName.equals("����S2 ��׼��͸Ĥ")){
			return "miS2";
		}else if(productName.equals("С��USB��������棨18W��")){
			return "miUsbCharger";
		}else{
			return "miUsbCharger";
		}
	}
	
	
}
