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
		User userTemp = (User) session.getAttribute("user");//notice
//		User userTemp = new User();
//		userTemp.setUserId(1);
		int totalQuantityOfShopcart = 0;
		if(userTemp!=null) {
			List<CartItem> list = homeservice.getCartItems(userTemp.getUserId());
			for(CartItem cartItem:list) {
				totalQuantityOfShopcart += cartItem.getQuantity();
			}
		}
		return totalQuantityOfShopcart;
	}
	@RequestMapping("load_cartItem")
	public @ResponseBody List<CartItem> getCartItems(HttpSession session){
		User userTemp = (User) session.getAttribute("user");//notice
//		User userTemp = new User();
//		userTemp.setUserId(1);
		List<CartItem> list = null;
		if(userTemp!=null) {
			list = homeservice.getCartItems(userTemp.getUserId());
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
	public void deleteCartItem(HttpServletRequest request) {
		int cartItemId = Integer.parseInt((String) request.getParameter("cartItemId"));
		homeservice.deleteCartItem(cartItemId);
	}
	/*
	 * get nav products data
	 */
	@RequestMapping("getNavmenu")
	public @ResponseBody List<Product> getNavProducts(HttpServletRequest request) {
		String navColumnName = (String)request.getParameter("navColumnName");
		return homeservice.getNavProducts(navColumnName);
	}
	/*
	 * get categorymenu product data 
	 */
	@RequestMapping("getCategorymenu")
	public @ResponseBody List<Product> getSecondClassProducts(HttpServletRequest request){
		String categoryItemName = request.getParameter("categoryItemName");
		return homeservice.getSecondClassProducts(categoryItemName);
	}
	/*
	 * quit login
	 */
	@RequestMapping("quitLogin")
	public void deleteUser(HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user!=null) {
			session.removeAttribute("user");
		}
	}
	
}






