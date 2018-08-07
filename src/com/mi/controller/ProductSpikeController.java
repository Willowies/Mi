package com.mi.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.SpikeProduct;
import com.mi.model.bean.User;
import com.mi.model.service.ProductSpikeService;

@Controller
@RequestMapping("mi")
public class ProductSpikeController {
	@Autowired
	private ProductSpikeService productSpikeService;	
	
	public User getUser(HttpSession session){
		User u = new User();
		u.setUserId(2);
		session.setAttribute("user", u);
		User user = (User) session.getAttribute("user");
		return user;
	}
	//根据秒杀时间查询秒杀商品
	@RequestMapping("selectSpikeProduct")
	public @ResponseBody List<SpikeProduct> selectSpikeProduct(String focusSpikeTime){
		int startTime = Integer.parseInt(focusSpikeTime);
		List<SpikeProduct> productList = productSpikeService.selectSpikeProduct(startTime);
		//System.out.println(productList.size());
		return productList;
	}
	//设置秒杀提醒
	@RequestMapping("addSpikeRemind")
	public @ResponseBody String addSpikeRemind(HttpServletRequest request, int spikeProductId, Date remindTime, HttpSession session){
		User user = getUser(session);
		spikeProductId = Integer.parseInt(request.getParameter("spikeProductId"));
		String isSetted = productSpikeService.addSpikeRemind(spikeProductId, user.getUserId(), remindTime);
		return isSetted;
	}
	//抢购商品
	@RequestMapping("buySpikeProduct")
	public @ResponseBody String buySpikeProduct(HttpServletRequest request, String spikeProductId, HttpSession session){
		
		//session.setAttribute("spikeProductId", Integer.parseInt(spikeProductId));
		String buySucceed = productSpikeService.selectBuySpikeProduct(Integer.parseInt(spikeProductId));
		System.out.println(buySucceed);
		return buySucceed;
	}
	//封装商品信息
	@RequestMapping("findSpikeProduct")
	public @ResponseBody OrderProduct findSpikeProduct(HttpServletRequest request, int spikeProductId){
		spikeProductId = Integer.parseInt(request.getParameter("spikeProductId"));
		OrderProduct orderProduct = productSpikeService.findSpikeProduct(spikeProductId);
		return orderProduct;
	}
	//发送消息提醒秒杀
	@RequestMapping("addSpikeMessage")
	public void addSpikeMessage(HttpServletRequest request, int spikeProductId, Date sendTime, HttpSession session){
		User user = getUser(session);
		spikeProductId = Integer.parseInt(request.getParameter("spikeProductId"));
		productSpikeService.addSpikeMessage(spikeProductId, user.getUserId(), sendTime);
	}
	//返回首页查找的秒杀商品列表
	@RequestMapping("selectIndexSpikeProduct")
	public @ResponseBody List<SpikeProduct> selectIndexSpikeProduct(Date currentDate){
		List<SpikeProduct> spikeList = productSpikeService.selectIndexSpikeProduct(currentDate);
		return spikeList;
	}
	


}
