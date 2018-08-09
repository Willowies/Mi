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
		List<Product> products = homeService.getRecommendProducts();
		model.addAttribute("recommendProduct", products);
		System.out.println("获得了推荐商品，且推荐商品的数量为"+products.size());
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
	public String addCartItem(String productIdString,String productName,HttpSession session,Model model){
		System.out.println("传过来的商品名为"+productName);
		User user = (User)session.getAttribute("user");
		int productId = Integer.parseInt(productIdString);
		int result = cartItemService.addCartItem(productId,user.getUserId());
		if(result==2){
			//达到商品最大限购数量
			//model.addAttribute("productName",productName);
			//model.addAttribute("message", "商品已到达最大限购数量");
			model.addAttribute("message", "商品已到达最大限购数量");
			System.out.println("要传过去的商品名为"+productName);
			System.out.println(productName);
			return p.selectProductInfo(model, productName, session);
		}else {
			//未达到商品最大限购数量
			//购物车中有该商品且未达到最大限购数量
			CartItem cartItem = cartItemService.selectCartItem(productId,user.getUserId());
			model.addAttribute("cartItem", cartItem);
			//model.addAttribute("message", "商品已加入购物车");
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
		System.out.println("productName的值为"+productName);
		System.out.println(productName);
		if(productName.equals("小米8")){
			return "xiaomi8";
		}else if(productName.equals("小米平板4")){
			return "miPad4";
		}else if(productName.equals("小米电视4")){
			return "TV4";
		}else if(productName.equals("红米note5")){
			return "miNote5";
		}else if(productName.equals("小米游戏本")){
			return "gameBook";
		}else if(productName.equals("米家空气净化器Pro")){
			return "airClean";
		}else if(productName.equals("小米6X 极简保护壳")){
			return "mi6X";
		}else if(productName.equals("红米S2 标准高透膜")){
			return "miS2";
		}else if(productName.equals("小米USB充电器快充版（18W）")){
			return "miUsbCharger";
		}else{
			return "miUsbCharger";
		}
	}
	
	
}
