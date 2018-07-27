package com.mi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
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
	public @ResponseBody int loadData(HttpSession session){
//		User userTemp = (User) session.getAttribute("user");//notice
		User userTemp = new User();
		userTemp.setUserId(1);
		
//		PrintWriter pw = response.getWriter();
//		StringBuffer sBuffer = null;
		
		if(userTemp!=null) {
			List<CartItem> list = getCartItems(userTemp);
//			response.setContentType("application/json;charset=utf-8");
//			sBuffer = new StringBuffer("");
			/*for(int i=0;i<list.size();i++){
				sBuffer.append("<p>");
				sBuffer.append(i+1);
				sBuffer.append("<img src=\"");
				sBuffer.append(list.get(i).getProduct().getPicUrl());
				sBuffer.append("\">");
				sBuffer.append(list.get(i).getProduct().getProductName());
				sBuffer.append(list.get(i).getProduct().getColor());
				sBuffer.append(list.get(i).getProduct().getProductPrice());
				sBuffer.append(" x ");
				sBuffer.append(list.get(i).getQuantity());
				sBuffer.append("</p>");
			}*/
			int totalQuantityOfShopcart = 0;
			for(int i=0;i<list.size();i++) {
				totalQuantityOfShopcart += list.get(i).getQuantity();
			}
			return totalQuantityOfShopcart;
		}else {
			//only get number of products in ShopCart
			//i saved it in session
			int numOfProInShopcart = getCartItems(session);
//			response.setContentType("text/plain;charset=UTF-8");
//			String jsonTotal = "{\"totalCartQuantity\":"+ numOfProInShopcart +"}";
//			sBuffer.append("[");
//			sBuffer.append(jsonTotal);
//			sBuffer.append(",");
//			System.out.println(sBuffer.toString());
			return numOfProInShopcart;
		}
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
		/*for(int i=0;i<list.size();i++) {
			switch (list.get(i).getSecondClassId()) {
			case 3:
				System.out.println("Appliance_sort: TV");
				list_tv.add(list.get(i));
				break;
			case 4:
				System.out.println("Appliance_sort: LAPTOP");
				list_laptop.add(list.get(i));
				break;
			default:
				break;
			}
		}
		List<List<Product>> list_sorted = new ArrayList<List<Product>>();
		list_sorted.add(list_tv);
		list_sorted.add(list_laptop);*/
		
		return list;
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
		/*for(int i=0;i<list.size();i++) {
			switch (list.get(i).getSecondClassId()) {
			case 5:
				System.out.println("Collocation_sort: TV");
				list_patchBoard.add(list.get(i));
				break;
			case 6:
				System.out.println("Collocation_sort: LAPTOP");
				list_phoneShell.add(list.get(i));
				break;
			default:
				break;
			}
		}
		List<List<Product>> list_sorted = new ArrayList<List<Product>>();
		list_sorted.add(list_patchBoard);
		list_sorted.add(list_phoneShell);*/
		
		return list;
	}
	
	
	
	/**
	 * get CartItem data
	 */
	public List<CartItem> getCartItems(User userTemp){
		return homeservice.getCartItems(userTemp.getUserId());
	}
	public int getCartItems(HttpSession session){
		int numOfProInShopcart = (int) session.getAttribute("cartItemNumber");
		return numOfProInShopcart;
	}
	
	
}



