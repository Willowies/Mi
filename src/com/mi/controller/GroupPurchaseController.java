package com.mi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.model.bean.Group;
import com.mi.model.bean.GroupProduct;
import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.User;
import com.mi.model.service.GroupPurchaseService;


@Controller
@RequestMapping("mi")
public class GroupPurchaseController {
	@Autowired
	GroupPurchaseService groupPurchaseService;
	
	@RequestMapping("load_groupProducts")
	public @ResponseBody List<GroupProduct> getGroupProducts(){
		return groupPurchaseService.getGroupProducts();
	}
	@RequestMapping("getGroupProductById")
	public @ResponseBody GroupProduct getGroupProductById(HttpServletRequest request) {
		int groupProductId = Integer.parseInt((String)request.getParameter("groupProductId"));
		return groupPurchaseService.getGroupProductById(groupProductId);
	}
	
	@RequestMapping("load_groups")
	public @ResponseBody List<Group> getProductGroups(HttpServletRequest request){
		//
		System.out.println("entered in load_groups");
		int groupProductId = Integer.parseInt((String)request.getParameter("groupProductId"));
		return groupPurchaseService.getProductGroups(groupProductId);
	}
	
	@RequestMapping("createGroup")
	public @ResponseBody int addGroup(HttpServletRequest request, HttpSession session) {
		int groupProductId = Integer.parseInt((String)request.getParameter("groupProductId"));
		//get user
		User userTemp = (User)session.getAttribute("user");
		//get userName
		String userName = userTemp.getUserName();
		/*User user = new User();
		user.setUserName("张三");*/
		int groupid = groupPurchaseService.addGroup(groupProductId, userName);
		System.out.println("groupid Controller"+groupid);
		session.setAttribute("groupId", groupid);
		return groupid;
	}
	@RequestMapping("judgeCurrentQuantity")
	public @ResponseBody int getCurrentQuantity(HttpServletRequest request) {
		int groupProductId = Integer.parseInt((String)request.getParameter("groupProductId"));
		return groupPurchaseService.getCurrentQuantity(groupProductId);
	}
	/*@RequestMapping("updateClearing")
	public void updateClearing(int groupProductId) {
		groupPurchaseService.updateClearing(groupProductId);
	}*/
	@RequestMapping("provideOrderProduct")
	public void getOrderProduct(HttpServletRequest request, HttpSession session) {
		int groupProductId = Integer.parseInt((String)request.getParameter("groupProductId"));
		OrderProduct result = groupPurchaseService.getOrderProduct(groupProductId); 
		session.setAttribute("orderProduct", result);
	}
	
}
