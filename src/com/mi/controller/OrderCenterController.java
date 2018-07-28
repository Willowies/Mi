package com.mi.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mi.model.bean.Order;
import com.mi.model.bean.User;
import com.mi.model.service.OrderCenterService;
import com.mi.utils.BaseController;

@Controller
@RequestMapping("mi")
public class OrderCenterController extends BaseController {
	@Autowired
	private OrderCenterService orderCenterService;
	
	@RequestMapping("getOrderByProductName")
	public String getOrderByProductName(HttpSession session,HttpServletRequest request,String productName,Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}
		
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getOrderByProductName(user,productName,page,5);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("orderList", orders);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}
	
	@RequestMapping("getOrderDetailsById")
	public String getOrderDetailsById(HttpSession session,HttpServletRequest request,Integer orderId) {
		if (orderId == null || orderId == 0) {
			return "homepage.jsp";
		}
		Order order = orderCenterService.getOrderDetailsById(orderId);
		
		request.setAttribute("order", order);
		
		return "forward:orderDetails.jsp";
	}
	
	@RequestMapping("getAllOrder")
	public String getAllOrder(HttpSession session,HttpServletRequest request,Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}
		
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getAllOrder(user,page,5);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("orderList", orders);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}
	
	@RequestMapping("getOrderWaitPaid")
	public String getOrderWaitPaid(HttpSession session,HttpServletRequest request,Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}
		
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getOrderByState(user, page, 5, 1);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("orderList", orders);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}
	
	@RequestMapping("getOrderWaitTaken")
	public String getOrderWaitTaken(HttpSession session,HttpServletRequest request,Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}
		
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getOrderByState(user, page, 5, 2);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("orderList", orders);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}
	
	@RequestMapping("getOrderClosed")
	public String getOrderClosed(HttpSession session,HttpServletRequest request,Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}
		
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getOrderByState(user, page, 5, 0);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("orderList", orders);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}
	
	@RequestMapping("getAllGroupOrder")
	public String getAllGroupOrder(HttpSession session,HttpServletRequest request,Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}
		
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getAllGroupOrder(user,page,5);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("orderList", orders);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}
	
	@RequestMapping("getGroupOrderWaitPaid")
	public String getGroupOrderWaitPaid(HttpSession session,HttpServletRequest request,Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}
		
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getGroupOrderByState(user, page, 5, 1);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("orderList", orders);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}
	
	@RequestMapping("getGroupOrderWaitTaken")
	public String getGroupOrderWaitTaken(HttpSession session,HttpServletRequest request,Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}
		
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getGroupOrderByState(user, page, 5, 2);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("orderList", orders);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}
	
	@RequestMapping("getGroupOrderWaitBuilt")
	public String getGroupOrderWaitBuilt(HttpSession session,HttpServletRequest request,Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}
		
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getGroupOrderByState(user, page, 5, 4);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("orderList", orders);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}
	
	@RequestMapping("getGroupOrderClosed")
	public String getGroupOrderClosed(HttpSession session,HttpServletRequest request,Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}
		
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getGroupOrderByState(user, page, 5, 0);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("orderList", orders);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}
	
	public User getUser(HttpSession session) {
		//User user = (User)session.getAttribute("user");
		
		User user = new User();
		user.setUserId(10001);
		return user;
	}

}
