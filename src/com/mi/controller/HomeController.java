package com.mi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.mi.model.bean.CartItem;
import com.mi.model.bean.GroupProduct;
import com.mi.model.bean.User;
import com.mi.model.service.HomeService;

@Controller
@RequestMapping("mi")
public class HomeController {
	@Autowired
	HomeService homeservice;
	
	@RequestMapping(value="load",produces = "application/json; charset=utf-8")
	public void loadData(HttpSession session, HttpServletResponse response) throws IOException{
		/*
		 * get CartItem data
		 */
//		User userTemp = (User) session.getAttribute("user");//notice
		User userTemp = new User();
		userTemp.setUserId(1);
		
		PrintWriter pw = response.getWriter();
		StringBuffer sBuffer = null;
		Gson json = new Gson();
		
		if(userTemp!=null) {
			List<CartItem> list = getCartItems(userTemp);
			response.setContentType("application/json;charset=utf-8");
			sBuffer = new StringBuffer("");
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
			String jsonTotal = "{\"totalCartQuantity\":"+ totalQuantityOfShopcart +"}";
			sBuffer.append("[");
			sBuffer.append(jsonTotal);
			sBuffer.append(",");
			System.out.println(sBuffer.toString());
//			pw.print(sBuffer.toString());
		}else {
			//only get number of products in ShopCart
			//i saved it in session
			int numOfProInShopcart = getCartItems(session);
//			response.setContentType("text/plain;charset=UTF-8");
			String jsonTotal = "{\"totalCartQuantity\":"+ numOfProInShopcart +"}";
			sBuffer.append("[");
			sBuffer.append(jsonTotal);
			sBuffer.append(",");
			System.out.println(sBuffer.toString());
		}
		/*
		 * get GroupProduct data
		 */
		List<GroupProduct> listGP = getGroupProducts();
		String jsonStr = json.toJson(listGP);
		System.out.println("jsonStr:"+jsonStr);
		String jsonGP = "{\"groupProduct\":"+ jsonStr +"}";
		sBuffer.append(jsonGP);
		sBuffer.append("]");
		System.out.println(sBuffer.toString());
//		String temp = new String(sBuffer.toString().getBytes(),"UTF-8");
		pw.print(sBuffer.toString());
//		pw.print(temp);
	}
	/*
	 * get CartItem data
	 */
	public List<CartItem> getCartItems(User userTemp){
		return homeservice.getCartItems(userTemp.getUserId());
	}
	public int getCartItems(HttpSession session){
		int numOfProInShopcart = (int) session.getAttribute("cartItemNumber");
		return numOfProInShopcart;
	}
	/*
	 * get GroupProduct data
	 */
	public List<GroupProduct> getGroupProducts(){
		return homeservice.getGroupProducts();
	}
	
}



