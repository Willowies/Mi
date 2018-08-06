package com.mi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mi.model.bean.CartItem;
import com.mi.model.bean.Product;
import com.mi.model.bean.User;
import com.mi.model.dao.CartItemDAO;
import com.mi.model.service.CartItemService;
import com.mi.utils.BaseController;

@Controller
@RequestMapping("mi")
public class CartItemController extends BaseController{
	@Autowired
	private CartItemService cartItemService;
	
	//待删，向session中加入userId
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
		return "cart";
	}
	
	@RequestMapping("deleteItem")
	public String deleteItem(int cartItemId){
		cartItemService.deleteItem(cartItemId);
		return "redirect:findCartItem.action";
	}
	
	@RequestMapping("updateItemQuantity")
	public String updateItemQuantity(int num,int cartItemId,Model model){
		System.out.println("进入updateItemQuantity方法");
		int result = cartItemService.updateItemQuantity(num, cartItemId);
		if(result==1){
			//达到商品购买最大数量
			model.addAttribute("message", "商品已到达最大限购数量");
		}else if(result==2){
			//商品数量为1
			
		}else{
			
		}
		return "forward:findCartItem.action";
	}
	
	@RequestMapping("addCartItem")
	public String addCartItem(int productId,HttpSession session,Model model){
		User user = (User)session.getAttribute("user");
		int result = cartItemService.addCartItem(productId,user.getUserId());
		if(result==2){
			//达到商品最大限购数量
			//model.addAttribute("productName",productName);
			model.addAttribute("message", "商品已到达最大限购数量");
			return "gotoCart";
		}else {
			//未达到商品最大限购数量
			//购物车中有该商品且未达到最大限购数量
			CartItem cartItem = cartItemService.selectCartItem(productId,user.getUserId());
			model.addAttribute("cartItem", cartItem);
			//model.addAttribute("message", "商品已加入购物车");
			return "addToCart";
		}
	}
	
	@RequestMapping("recommendProduct")
	public String recommendProduct(Model model){
		List<Product> products = cartItemService.recommendProduct();
		model.addAttribute("products", products);
		return "gotoCart";
	}
}
