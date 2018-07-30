package com.mi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.model.bean.CartItem;
import com.mi.model.bean.GroupProduct;
import com.mi.model.bean.Product;
import com.mi.model.bean.User;
import com.mi.model.service.HomeService;

@Controller
@RequestMapping("mi")
public class HomeController {
	@Autowired
	HomeService homeservice;
	
	/*
	 * get CartItem data
	 */
	@RequestMapping("load_cart")
	public @ResponseBody int getCartItemsNum(HttpSession session){
//		User userTemp = (User) session.getAttribute("user");//notice
		User userTemp = new User();
		userTemp.setUserId(1);
		
		if(userTemp!=null) {
			List<CartItem> list = homeservice.getCartItems(userTemp.getUserId());
			int totalQuantityOfShopcart = 0;
			for(int i=0;i<list.size();i++) {
				totalQuantityOfShopcart += list.get(i).getQuantity();
			}
			return totalQuantityOfShopcart;
		}else {
			//only get number of products in ShopCart
			//i saved it in session
			int numOfProInShopcart = (int) session.getAttribute("cartItemNumber");
			return numOfProInShopcart;
		}
	}
	@RequestMapping("load_cartItem")
	public @ResponseBody List<CartItem> getCartItems(HttpSession session){
//		User userTemp = (User) session.getAttribute("user");//notice
		User userTemp = new User();
		userTemp.setUserId(1);
		List<CartItem> list = null;
		if(userTemp!=null) {
			list = homeservice.getCartItems(userTemp.getUserId());
		}else {
			list = (ArrayList<CartItem>) session.getAttribute("cartItemList");
		}
		return list;
	}
	
	/*
	 * get GroupProduct data
	 */
	@RequestMapping("load_gp")
	public @ResponseBody List<GroupProduct> getGroupProducts(){
		return homeservice.getGroupProducts();
	}
	/*
	 * get phone data
	 */
	@RequestMapping("load_phone")
	public @ResponseBody List<Product> getPhoneProducts(){
		return homeservice.getPhoneProducts();
	}
	/*
	 * get popular appliance product
	 */
	@RequestMapping("load_popularAppliance")
	public @ResponseBody List<Product> getPopularProductsOfAppliance(){
		return homeservice.getPopularProductsOfAppliance();
	}
	/*
	 * get appliance product data
	 */
	@RequestMapping("load_appliance")
	public @ResponseBody List<Product> getApplianceProducts(){
		List<Product> list = homeservice.getApplianceProducts();
		//handle the list according to different product types
		/*List<Product> list_tv = new ArrayList<Product>();
		List<Product> list_laptop = new ArrayList<Product>();*/
		////////////
		System.out.println("Appliance list-size:"+list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getProductName());
		}
		////////////
		return list;
	}
	/*
	 * get popular collocation product
	 */
	@RequestMapping("load_popularCollocation")
	public @ResponseBody List<Product> getPopularProductsOfCollocation(){
		return homeservice.getPopularProductsOfCollocation();
	}
	/*
	 * get accessory product data
	 */
	@RequestMapping("load_collocation")
	public @ResponseBody List<Product> getCollocationProducts(){
		List<Product> list = homeservice.getCollocationProducts();
		//handle the list according to different product types
		/*List<Product> list_patchBoard = new ArrayList<Product>();
		List<Product> list_phoneShell = new ArrayList<Product>();*/
		////////////
		System.out.println("Collocation list-size:"+list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getProductName());
		}
		////////////		
		return list;
	}
	/*
	 * get recommend product data
	 */
	@RequestMapping("load_recommend")
	public @ResponseBody List<Product> getRecommendProducts(){
		return homeservice.getRecommendProducts();
	}
	/*
	 * get popular product data
	 */
	@RequestMapping("load_popular")
	public @ResponseBody List<Product> getPopularProducts(){
		return homeservice.getPopularProducts();
	}
	/*
	 * delete cart item data
	 */
	@RequestMapping("deleteCartItem")
	public void deleteCartItem(HttpServletRequest request, HttpSession session) {
		int cartItemId = Integer.parseInt((String) request.getAttribute("cartItemId"));
		List<CartItem> list = (ArrayList<CartItem>) session.getAttribute("cartItems");
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCartItem()==cartItemId) {
				list.remove(i);
			}
		}
	}
	/*
	 * get nav products data
	 */
	@RequestMapping("getNavmenu")
	public @ResponseBody List<Product> getNavProducts(HttpServletRequest request) {
		String productName = (String)request.getParameter("productName");
		System.out.println("getNavmenu------"+productName);
		String navColumnName;
		switch(productName) {
		case "小米手机":
			navColumnName = "小米";
			break;
		case "红米":
			navColumnName = "红米";
			break;
		case "电视":
			navColumnName = "电视";
			break;
		case "笔记本":
			navColumnName = "";
			break;
		case "盒子":
			navColumnName = "";
			break;
		case "新品":
			navColumnName = "";
			break;
		case "路由器":
			navColumnName = "路由器";
			break;
		case "智能硬件":
			navColumnName = "";
			break;
		default:
			navColumnName = "";
			break;
		}
		System.out.println("navColumnName:::"+navColumnName);
		return homeservice.getNavProducts(navColumnName);
	}
	/*
	 * get categorymenu product data 
	 */
	@RequestMapping("getCategorymenu")
	public @ResponseBody List<Product> getSecondClassProducts(){
		return homeservice.getSecondClassProducts();
	}
	
	
}






